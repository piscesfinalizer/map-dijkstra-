import java.util.Arrays;
import java.util.List;

public class Map {//参考领接矩阵的无向图类
	private List<String> vexs;//存放结点，这里结点的描述为String类型，放在数组中
	private int[][] arc;//边的信息
	private int numVertexes,numEdges;//顶点数与边数
	public static int INFINITY = 65535;//定义一个最大值

	public Map(int vexnum, int edgenum) {//构造函数
		numVertexes = vexnum;
		numEdges = edgenum;
		vexs = Arrays.asList(new String[vexnum]);

		arc = new int[vexnum][vexnum];
	}

	public int getNumVertexes() {
		return numVertexes;
	}//返回定点数

	public int getNumEdges() {
		return numEdges;
	}

	public String getvexs(int i) {
		return vexs.get(i);
	}//得到顶点

	public int getIndexof(String s) {
		return vexs.indexOf(s);
	}//得到顶点的索引

	public int getArc(int i, int j) {
		return arc[i][j];
	}//得到边的权值

	public void setNumVertexes(int n) {
		numVertexes = n;
	}

	public void setNumEdges(int n) {
		numEdges = n;
	}

	public void setVexs(String s,int i) {
		vexs.set(i,s);
	}//设定顶点信息

	public void setArc(int i, int j, int value) {
		arc[i][j] = value;
	}//设定边的信息

	public Map(){//构造函数重载，这里用作特定的构造，参数固定
		numVertexes = 14;
		numEdges = 16;
		vexs = Arrays.asList(new String[numVertexes]);
		arc = new int[numVertexes][numVertexes];
		int i,j,k,w;
		for(i = 0; i < numVertexes; i++) {//设定顶点
			setVexs(Servlet.places[i].trim(), i);
		}

		for(i = 0; i < numVertexes; i++) {
			for(j = 0; j < numVertexes; j++) {
				setArc(i, j, INFINITY);//边初始化为最大，不连通
			}
		}

		for(k = 0; k < numEdges; k++) {//设定边的信息
			String s1 = Servlet.sourse[k];
			String s2 = Servlet.destination[k];
			w = Servlet.distance[k];
			setArc(getIndexof(s1), getIndexof(s2), w);
			setArc(getIndexof(s2), getIndexof(s1), w);
		}

	}

}
