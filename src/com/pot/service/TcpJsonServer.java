//package com.pot.service;
//
//import java.io.BufferedOutputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//
//import net.sf.json.JSONObject;
//
//public class TcpJsonServer {
//	
//	public static final int PORT = 12345;//�����Ķ˿ں�     
//    
//    public static void main(String[] args) throws ServletException {    
//        System.out.println("����������...\n");    
//      //  System.loadLibrary(Core.NATIVE_LIBRARY_NAME);  
//        Server server = new Server();    
//        server.init();    
//    }    
//    
//    public void init() {    
//        try {    
//            ServerSocket serverSocket = new ServerSocket(PORT);    
//            while (true) {    
//                // һ���ж���, ���ʾ��������ͻ��˻��������    
//                Socket client = serverSocket.accept();    
//                // �����������    
//                new HandlerThread(client);    
//            }    
//        } catch (Exception e) {    
//            System.out.println("�������쳣: " + e.getMessage());    
//        }    
//    }    
//    
//    private class HandlerThread implements Runnable {    
//        private Socket socket;    
//        public HandlerThread(Socket client) {    
//            socket = client;    
//            new Thread(this).start();    
//        }    
//    
//        public void run() {    
//               
//            try {    
//                // ��ȡ�ͻ�������    
//                System.out.println("�ͻ��������Ѿ�����");  
//                DataInputStream inputStream = null;  
//                DataOutputStream outputStream = null;  
//                String strInputstream ="";           
//                inputStream =new DataInputStream(socket.getInputStream());                   
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();  
//                byte[] by = new byte[2048];  
//                int n;  
//                while((n=inputStream.read(by))!=-1){  
//                    baos.write(by,0,n);           
//                }  
//                strInputstream = new String(baos.toByteArray());  
////                System.out.println("���ܵ������ݳ���Ϊ��"+strInputstream);  
//                socket.shutdownInput();  
////                inputStream.close();  
//                baos.close();  
//                  
//                  
//                // �����ͻ�������    
//                //��socket���ܵ������ݻ�ԭΪJSONObject  
//                JSONObject json = new JSONObject(strInputstream);         
//                int op =Integer.parseInt((String)json.get("op"));    
//                System.out.println(op);  
//                switch(op){  
//                  
//                //opΪ1 ��ʾ�յ��Ŀͻ��˵�����Ϊע����Ϣ     opΪ2��ʾ�յ��ͻ��˵�����Ϊ������Ϣ       
//                  
//                //���û����еĲ�����ע��ʱ  
//                case 1: String imgStr = json.getString("img");  
//                        String name   = json.getString("name");  
//                       //isSuccess ��ʾ�Ƿ�ע��ɹ�  
//                        String isSuccess="1";  
//                       // System.out.println("imgStr:"+imgStr);  
//                        //��ϵͳʱ����Ϊ����ͼƬ������   ��ʽΪyyyy-MM-dd-HH-mm-ss  
//                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");  
//                        String imgName = df.format(new Date());  
//                        Base64Image.GenerateImage(imgStr,"D:\\fromjia\\imageDB\\primary\\"+imgName+".jpg");  
//                        //do something to process this image                        
//                        //if success, return set isSuccess "1"  
//                        //else set "0"    
//                        System.out.println(name);                   
//                        System.out.println("�����������������");  
//                          
//                        // ��ͻ��˻ظ���Ϣ  --json����//to be continued;  
//                        Map<String, String> map = new HashMap<String, String>();  
//                        map.put("isSuccess", isSuccess);  
//                        json = new JSONObject(map);  
//                    String jsonString = json.toString();                        
//                    outputStream = new DataOutputStream(new BufferedOutputStream (socket.getOutputStream()));     
//                    outputStream.writeUTF(jsonString);  
//                    outputStream.flush();  
//                    outputStream.close();  
//                    System.out.println("ע�����");  
//                        break;                                                                                         
//                }   
//                  
//                outputStream.close();  
//            } catch (Exception e) {    
//                System.out.println("������ run �쳣: " + e.getMessage());    
//            } finally {    
//                if (socket != null) {    
//                    try {    
//                        socket.close();    
//                    } catch (Exception e) {    
//                        socket = null;    
//                        System.out.println("����� finally �쳣:" + e.getMessage());    
//                    }    
//                }    
//            }   
//        }    
//    }    
//}