package com.ycx.manager.controller;

import java.io.File;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ycx.manager.ClassUtil.DateUtil;
import com.ycx.manager.ClassUtil.JsonUtils;
import com.ycx.manager.Dto.MovieInformationDto;
import com.ycx.manager.bean.LoginUser;
import com.ycx.manager.bean.MovieInformation;
import com.ycx.manager.bean.Pagination;
import com.ycx.manager.bean.PictureInformation;
import com.ycx.manager.bean.ScheduleMovie;
import com.ycx.manager.service.MovieInformationService;
import com.ycx.manager.service.UploadManager;

import net.sf.json.JSONObject;

/**
* @author Create By Yangchunxue
* @date   2017年10月21日--下午6:44:38--
*
*/
@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieInformationService movieInformationService;
	
	@Autowired
	private UploadManager uploadManager;
	
	
	@RequestMapping("/publish.do")
	public ModelAndView  publish(){
		return new ModelAndView("/system/movie/movieList");
	}
	
	
	@RequestMapping(value = "/getMovieInformation.do")
	@ResponseBody
	public String getMovieInformation(MovieInformationDto movieInfoDto,HttpSession session) {
		movieInfoDto.setLimit(movieInfoDto.getPgLimit());
		movieInfoDto.setPgNumber(movieInfoDto.getPgCurrentPage());
		movieInfoDto.setStatus(0);
		Pagination carpagination = movieInformationService.getMovieInformation(movieInfoDto);
		JSONObject jsonResult = JsonUtils.toGridJson(carpagination.getTotalCount(),carpagination.getResultList());
		return jsonResult.toString();
	}
	
	
	@RequestMapping("/addMovieInfo.do")
	public ModelAndView addMovieInfo() {
		return new ModelAndView("/system/movie/addMovieInfo");
	}
	
	
	
		@RequestMapping(value = "/saveMovieInfo.do")
		public ModelAndView saveMovieInfo(HttpServletRequest request, MovieInformation movieInfo, HttpSession session) {
			String editorValue = request.getParameter("editorValue");
			Long id = System.currentTimeMillis();
			movieInfo.setID(id.toString());
			movieInfo.setIntroduce(editorValue);
			LoginUser loginUser = (LoginUser) session.getAttribute("SESSION_LOGIN_USER");
			movieInfo.setOperator(loginUser.getLoginName());
			movieInformationService.insertMovieInformation(movieInfo);
			return new ModelAndView("/system/movie/movieList");

		}
		
		
		
		
		@RequestMapping(value = "/uploadInfoPic.do")
		public ModelAndView uploadInfoPic(@RequestParam("movieId") String movieId, Model model) {
			model.addAttribute("movieId", movieId);
			return new ModelAndView("/system/movie/uploadMovieInfoPic");
		}
      /*上传图片*/
		@RequestMapping(value = "/uploadImage.do")
		public void uploadToServer(@RequestParam("movieId") Long movieId,@RequestParam(value = "file", required = false) MultipartFile file, HttpSession session) {
		  // 保存
		 	try {
			     String name = file.getOriginalFilename();
			     String lastname=name.substring(name.lastIndexOf("."),name.length());
			     String firstName = "ycx-" +  System.currentTimeMillis();
				 String fileName = firstName+lastname;
			     File targetFile = dealPath(name,fileName);
			     System.out.println(targetFile.getAbsolutePath());
		 		file.transferTo(targetFile);
		 		PictureInformation pictureInformation = new PictureInformation();
		 		pictureInformation.setId(System.currentTimeMillis());
		 		pictureInformation.setMovieId(movieId);
		 		pictureInformation.setOriginalName(name);
		 		pictureInformation.setUrl("/uploadImage/"+fileName);
		 		movieInformationService.savePictue( pictureInformation,1);
		 	} catch (Exception e) {
		 		e.printStackTrace();
		 	}
		}
		
		
	    /*上传主图片*/
		
		@RequestMapping(value = "/uploadMainPictureInit.do")
		public ModelAndView uploadMainPictureInit(@RequestParam("movieId") String movieId, Model model) {
			model.addAttribute("movieId", movieId);
			return new ModelAndView("/system/movie/uploadMovieInfoMainPic");
		}
		
			@RequestMapping(value = "/uploadMainPicture.do")
			public void uploadMainPicture(@RequestParam("movieId") Long movieId,@RequestParam(value = "file", required = false) MultipartFile file, HttpSession session) {
			  // 保存
			 	try {
				     String name = file.getOriginalFilename();
				     String lastname=name.substring(name.lastIndexOf("."),name.length());
				     String firstName = "ycx-" +  System.currentTimeMillis();
					 String fileName = firstName+lastname;
				     File targetFile = dealPath(name,fileName);
				     System.out.println(targetFile.getAbsolutePath());
			 		file.transferTo(targetFile);
			 		PictureInformation pictureInformation = new PictureInformation();
			 		pictureInformation.setId(System.currentTimeMillis());
			 		pictureInformation.setMain(1);
			 		pictureInformation.setMovieId(movieId);
			 		pictureInformation.setOriginalName(name);
			 		pictureInformation.setUrl("/uploadImage/"+fileName);
			 		movieInformationService.savePictue( pictureInformation,0);
			 	} catch (Exception e) {
			 		e.printStackTrace();
			 	}
			}


		private File dealPath(String name, String fileName) {
			 String classPath = MovieController.class.getClassLoader().getResource("").getPath(); // 经过测试，这种方法是安全的，最有效的
				String filePath = null;
				if(StringUtils.isNotEmpty(classPath) && classPath.contains("/WEB-INF/classes")){
					filePath = classPath.substring(0,classPath.indexOf("/WEB-INF/classes"));
				}
				// windows是\，unix是/
				if (StringUtils.isNotEmpty(filePath)&&"/".equals(File.separator)) {
					filePath = filePath.replace("\\", "/");
				}
				filePath = filePath+"/uploadImage";
				File targetFile = new File(filePath, fileName);
				if (!targetFile.exists()) {
						targetFile.mkdirs();
					}
			return targetFile;
		}
		
		@RequestMapping(value = "/publishMovie.do")
		public ModelAndView publishMovie(@RequestParam("movieId") String movieId, Model model) {
			movieInformationService.publish(movieId);
			return new ModelAndView("/system/movie/movieList");
		}
		
		
		@RequestMapping(value = "/undercarriage.do")
		public ModelAndView undercarriage(@RequestParam("movieId") String movieId, Model model) {
			movieInformationService.undercarriage(movieId);
			return new ModelAndView("/system/movie/movieList");
		}
		
		@RequestMapping(value = "/editMovie.do")
		public ModelAndView editMovie(@RequestParam("movieId") String movieId, Model model) {
			
			MovieInformation movieInformation = new MovieInformation();
			movieInformation = movieInformationService.getMovieInfoById(movieId);
			model.addAttribute("movieInformation", movieInformation);
			return new ModelAndView("/system/movie/editMovie");
		}
		
		
		
		
		@RequestMapping(value = "/updateMovieInfo.do")
		public ModelAndView updateMovieInfo(HttpServletRequest request, MovieInformation movieInfo, HttpSession session) {
			String editorValue = request.getParameter("editorValue");
			movieInfo.setIntroduce(editorValue);
			LoginUser loginUser = (LoginUser) session.getAttribute("SESSION_LOGIN_USER");
			movieInfo.setOperator(loginUser.getLoginName());
			movieInformationService.updateMovieInfo(movieInfo);
			return new ModelAndView("/system/movie/movieList");

		}
		
		
		
			
		@RequestMapping("/movieHasPublish.do")
		public ModelAndView  movieHasPublish(){
			return new ModelAndView("/system/movie/movieHasPublishList");
		}
		
		
		
		@RequestMapping(value = "/getMovieHasPublishInformation.do")
		@ResponseBody
		public String getMovieHasPublishInformation(MovieInformationDto movieInfoDto,HttpSession session) {
			movieInfoDto.setLimit(movieInfoDto.getPgLimit());
			movieInfoDto.setPgNumber(movieInfoDto.getPgCurrentPage());
			movieInfoDto.setStatus(1);
			Pagination carpagination = movieInformationService.getMovieInformation(movieInfoDto);
			JSONObject jsonResult = JsonUtils.toGridJson(carpagination.getTotalCount(),carpagination.getResultList());
			return jsonResult.toString();
		}
		
		
		@RequestMapping(value = "/DateMovie.do")
		@ResponseBody
		public ModelAndView DateMovie(ScheduleMovie scheduleMovie,HttpSession session) throws ParseException {
			scheduleMovie.setDate(DateUtil.toDateTime(scheduleMovie.getDate1()));
			scheduleMovie.setId(System.currentTimeMillis());
			movieInformationService.DateMovie(scheduleMovie);
			return new ModelAndView("/system/movie/movieList");
		}
		
		

}
