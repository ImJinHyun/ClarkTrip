package com.clark.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.clark.web.model.Editor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class EditorController {

	@Value("${file.upload-dir}") String path;
    @Value("${service.env}") String env;


    @RequestMapping(value="/summer", method = RequestMethod.POST )
    @ResponseBody
    public Map<String,Object> uploaddd(HttpServletRequest request,@RequestPart(value = "files") MultipartFile file) {
    	Map<String, Object> msg = new HashMap<>();
    	try {
    		
    	
    	String filename = file.getOriginalFilename();
        // 파일확장자
        String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
        //확장자를소문자로 변경
        filename_ext = filename_ext.toLowerCase();
        
        //파일 기본경로 _ 상세경로
        String filePath = "";
        
        if ("local".equals(env)) {
        // 로컬
         filePath ="C:/wonju0425/tomcat/upload/";
        } else {
        // 서버
         filePath = "/wonju0425/tomcat/upload/";
        }
        
        File makefile = new File(filePath);
        
        if(!makefile.exists()) {
        	makefile.mkdirs();
            // 폴더 권한 부여

            String cmd = "chmod 777 -R " + "C:/wonju0425/tomcat/upload/.";     // 750, 770등 권한을 부여하고 -R옵션은 하위 디렉토리 생성시 같은 권한 부여 옵션으로
            Runtime rt = Runtime.getRuntime();

            Process prc = rt.exec(cmd);

            prc.waitFor();
        }
        
        String realFileNm = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String today= formatter.format(new java.util.Date());
        realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
        String rlFileNm = filePath + realFileNm;
        
        File saveFile = new File(rlFileNm);
        
        file.transferTo(saveFile);
        msg.put("url", "/upload/"+realFileNm);
        System.out.println(msg.get("url"));
    	} catch (Exception e) {
			// TODO: handle exception
		}
    	return msg;
    }
    

    @RequestMapping("/file_uploader_html5")
    public void file_uploader_html5(HttpServletRequest request, HttpServletResponse response, Editor editor) {
        try {
            // 파일정보
            String sFileInfo = "";

            request.setCharacterEncoding("UTF-8");
            
            //파일명을 받는다 - 멀티파일 업로드는 header로 넘어옴
            String filename = request.getHeader("file-name");
            
            // 파일확장자
            String filename_ext = filename.substring(filename.lastIndexOf(".")+1);

            //확장자를소문자로 변경
            filename_ext = filename_ext.toLowerCase();

            //이미지 검증 배열변수
            String[] allow_file = {"jpg","png","bmp","gif"};
            //돌리면서 확장자가 이미지인지
            int cnt = 0;
            for(int i=0; i<allow_file.length; i++) {
                if(filename_ext.equals(allow_file[i])){
                    cnt++;
                }
            }

            //이미지가 아님
            if(cnt == 0) {
                PrintWriter print = response.getWriter();
                print.print("NOTALLOW_"+filename);
                print.flush();
                print.close();
            } else {

                //이미지이므로 신규 파일로 디렉토리 설정 및 업로드
                // 파일 기본경로
                String dftFilePath = request.getServletContext().getRealPath("/");
                
                //파일 기본경로 _ 상세경로
                String filePath = "";
                if ("local".equals(env)) {
                // 로컬
                 filePath ="C:/wonju0425/tomcat/upload/";
                } else {
                // 서버
                 filePath = "/wonju0425/tomcat/upload/";
                }

                System.out.println(path);
                System.out.println(dftFilePath);
                System.out.println(filePath);
                File file = new File(filePath);

                if(!file.exists()) {
                    file.mkdirs();
                    // 폴더 권한 부여

                    String cmd = "chmod 777 -R " + "C:/wonju0425/tomcat/upload/.";     // 750, 770등 권한을 부여하고 -R옵션은 하위 디렉토리 생성시 같은 권한 부여 옵션으로
                    Runtime rt = Runtime.getRuntime();

                    Process prc = rt.exec(cmd);

                    prc.waitFor();
                }




                String realFileNm = "";
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                String today= formatter.format(new java.util.Date());
                realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
                String rlFileNm = filePath + realFileNm;
                System.out.println("realFileNm : "+realFileNm);
                System.out.println("rNm : "+rlFileNm);
                ///////////////// 서버에 파일쓰기 /////////////////
                InputStream is = request.getInputStream();
                OutputStream os=new FileOutputStream(rlFileNm);
                int numRead = 0;
                byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))/2];

                System.out.println("byte b =" +b);

                while((numRead = is.read(b,0,b.length)) != -1){
                    os.write(b,0,numRead);
                }
                if(is != null) {
                    is.close();
                }
                os.close();
                ///////////////// 서버에 파일쓰기 /////////////////

                sFileInfo += "&bNewLine=true";
                // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
                sFileInfo += "&sFileName="+ filename;
                sFileInfo += "&sFileURL="+"/upload/"+realFileNm;
                System.out.println(sFileInfo);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("multipart/form-data; charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println(sFileInfo);
                out.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/file_uploader")
    public String file_uploader(HttpServletRequest request, HttpServletResponse response, Editor editor) {
        String return1 = request.getParameter("callback");
        String return2 = "?callback_func=" + request.getParameter("callback_func");
        String return3 = "";
        String name = "";
        try {
            if (editor.getFiledata() != null && editor.getFiledata().getOriginalFilename() != null && !editor.getFiledata().getOriginalFilename().equals("")) {
                // 기존 상단 코드를 막고 하단코드를 이용
                name = editor.getFiledata().getOriginalFilename().substring(editor.getFiledata().getOriginalFilename().lastIndexOf(File.separator) + 1);
                String filename_ext = name.substring(name.lastIndexOf(".") + 1);
                filename_ext = filename_ext.toLowerCase();
                String[] allow_file = {"jpg", "png", "bmp", "gif"};
                int cnt = 0;
                for (int i = 0; i < allow_file.length; i++) {
                    if (filename_ext.equals(allow_file[i])) {
                        cnt++;
                    }
                }
                if (cnt == 0) {
                    return3 = "&errstr=" + name;
                } else {
                    //파일 기본경로
                    String dftFilePath = request.getSession().getServletContext().getRealPath("/");

                    //파일 기본경로 _ 상세경로
                    String filePath = "";
                    if ("local".equals(env)) {
                        // 로컬
                        filePath ="C:/wonju0425/tomcat/upload/" + File.separator;
                    } else {
                        // 서버
                        filePath = "/wonju0425/tomcat/upload/" + File.separator;
                    }

                    File file = new File(filePath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String realFileNm = "";
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                    String rlFileNm = filePath + realFileNm;
                    ///////////////// 서버에 파일쓰기 /////////////////
                    editor.getFiledata().transferTo(new File(rlFileNm));
                    ///////////////// 서버에 파일쓰기 /////////////////
                    return3 += "&bNewLine=true";
                    return3 += "&sFileName=" + name;
                    return3 += "&sFileURL=/upload/" + realFileNm;
                }
            } else {
                return3 += "&errstr=error";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:" + return1 + return2 + return3;
    }
}
