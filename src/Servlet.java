import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends javax.servlet.http.HttpServlet {
    public static String[] places = {"南门","西南门","海洋学院","商学院","知行楼","图书馆","科学实验楼","东门","体育馆","空间物理学院","北门","泰园餐厅","西门","风雨操场"};//顶点
    public static String[] sourse = {"南门","南门","海洋学院","海洋学院","商学院","商学院","商学院","科学实验楼","风雨操场","图书馆","体育馆","体育馆","体育馆","泰园餐厅","泰园餐厅","图书馆"};
    public static String[] destination = {"海洋学院","西南门","知行楼","商学院","东门","图书馆","科学实验楼","风雨操场","北门","体育馆","空间物理学院","西门","泰园餐厅","西门","西南门","科学实验楼"};
    public static int[] distance = {250,585,162,93,338,244,243,204,168,288,164,344,419,331,264,218};
    //sourse,destination,diatance描述边
    public static Map map = new Map();//初始化map

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置相应内容类型
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //实例化输出流对象
        PrintWriter printWriter = response.getWriter();
        DijKstra dj = new DijKstra(14);
        dj.ShortestPath(map, request.getParameter("sourse").trim());

        printWriter.println("最短路径为：" + dj.printPath(request.getParameter("destination").trim()));
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
