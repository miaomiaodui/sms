package com.student.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;
import com.student.pojo.Company;
import com.student.service.CompanyService;


import util.Page;


/**
 * Servlet implementation class StudentServlet
 */
public class CompanyServlet extends HttpServlet {
	CompanyService service=new CompanyService();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompanyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String m = request.getParameter("m");
		if(m.equals("list")){
			list(request, response);
		}
		else if(m.equals("getById")){
			getById(request,response);
		}
		else if(m.equals("update")){
			update(request,response);
		}
		else if(m.equals("del")){
			del(request,response);
		}else if(m.equals("add")) {
			add(request,response);
		}
	}


	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		boolean b = service.del(Integer.parseInt(id));
		response.getWriter().print(b);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// 判断request是否是Multipart/form-data
		boolean b = ServletFileUpload.isMultipartContent(request);
		Company company = new Company();
		if (b) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> list = upload.parseRequest(request);
				for (FileItem fileItem : list) {
					if (fileItem.isFormField()) {
						String fieldName = fileItem.getFieldName();
						if (fieldName.equals("id")) {
							company.setId(Integer.parseInt(fileItem.getString("UTF-8")));
						}
						if (fieldName.equals("name")) {
							company.setName(fileItem.getString("UTF-8"));
						}
						if (fieldName.equals("sname")) {
							company.setSname(fileItem.getString("UTF-8"));
						}
					}else{
						String filename = fileItem.getName();
						System.out.println(filename);
						if (filename!=null&&!filename.equals("")) {
							String realPath = getServletContext().getRealPath("/upload/");
							File dir=new File(realPath);
							if (!dir.exists()) {
								dir.mkdirs();
							}
							File destFile=new File(dir,filename);
							fileItem.write(destFile);
							System.out.println("upload...");
							company.setFilepath(request.getContextPath()+"/upload/"+filename);
							
						}
					}
					
					
				}
				boolean flag=service.update(company);
				response.getWriter().print(flag);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

	private void getById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		Company company = service.getById(Integer.parseInt(id));
		String json = JSON.toJSONString(company);
		response.getWriter().print(json);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Company> list = service.list();
		String json = JSON.toJSONString(list);
		response.getWriter().print(json);
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		// 判断request是否是Multipart/form-data
		boolean b = ServletFileUpload.isMultipartContent(request);
		Company company = new Company();
		if (b) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> list = upload.parseRequest(request);
				for (FileItem fileItem : list) {
					if (fileItem.isFormField()) {
						String fieldName = fileItem.getFieldName();
						if (fieldName.equals("name")) {
							company.setName(fileItem.getString("UTF-8"));
						}
						if (fieldName.equals("sname")) {
							company.setSname(fileItem.getString("UTF-8"));
						}
					}else{
						String filename = fileItem.getName();
						System.out.println(filename);
						if (filename!=null&&!filename.equals("")) {
							String realPath = getServletContext().getRealPath("/upload/");
							File dir=new File(realPath);
							if (!dir.exists()) {
								dir.mkdirs();
							}
							File destFile=new File(dir,filename);
							fileItem.write(destFile);
							System.out.println("upload...");
							System.out.println(request.getContextPath());
							company.setFilepath(request.getContextPath()+"/upload/"+filename);
							
						}
					}
					
					
				}
				System.out.println(company);
				boolean flag=service.add(company);
				response.getWriter().print(flag);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}
