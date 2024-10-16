public class FileUpload2 extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String CHARSET = "utf-8";
	String ATTACHES_DIR = "c:\\java\\temp";

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding(CHARSET);
		PrintWriter out = response.getWriter();
		
		String contentType = request.getContentType();

		String categ  = request.getParameter("categ");
		System.out.printf("categ= %s  \n", categ);
	
		if (contentType != null && contentType.toLowerCase().startsWith("multipart/") ){
			Collection<Part> parts  = request.getParts();
			System.out.println("contentType = " +contentType);
			for(Part part : parts) {
				System.out.printf("파라미터 명 : %s, contentType :  %s,  size : %d bytes \n", part.getName(),
						part.getContentType(), part.getSize());
				if(part.getHeader("Content-Disposition").contains("filename=")){
					String fileName = extractFileName(part.getHeader("Content-Disposition"));
				
					if(part.getSize()>0){
						System.out.printf("업로드 파일 명 : %s  \n", fileName);
						part.write(ATTACHES_DIR + File.separator + fileName);
						part.delete();
					}
					
				} else {
					String formValue = request.getParameter(part.getName());
					System.out.printf("name : %s, value : %s  \n", part.getName(), formValue);
					
				}
				out.println("<h1>업로드 완료</h1>");
			}
		} else {
			out.println("<h1>enctype이 multipart/form-data가  아님</h1>");
		}
		
	}
	
	private String extractFileName(String parHeader) {
		for (String cd: parHeader.split(";")) {
			if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf("=") + 1).trim().replace("\"","");
				int index = fileName.lastIndexOf(File.separator);
				return fileName.substring( index + 1);
			}
		}
		return null;
	}

	
}
