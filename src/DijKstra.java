import java.util.LinkedList;

public class DijKstra {
	private int[] patharc;//用于储存最短路径下标的数组
	private int[] shortPathTable;//储存从起始点到其他顶点的最短路径的数值
	private int[] finalPath;//标志数组，1表示已经求得初始点到这个点的最短路径
	private Map G;
	private int v0;//初始点的索引值

	public DijKstra(int num) {
		patharc = new int[num];
		shortPathTable = new int[num];
		finalPath = new int[num];

	}

	public void ShortestPath(Map M, String s) {
		int v,w,k = 0,min = 0;
		G = M;
		v0 = G.getIndexof(s.trim());


		for(v = 0; v < G.getNumVertexes(); v++) {//初始化数据
			finalPath[v] = 0;//全部初始化为未知最短路径状态
			shortPathTable[v] = G.getArc(v0, v);//将与v0点有连线的顶点加上权值
			patharc[v] = v0;//初始化为初始点v0
		}

		shortPathTable[v0] = 0;//v0到v0路径为0
		finalPath[v0] = 1;//v0到v0不需要求路径

		/*开始主循环,每次求得v0到某个v顶点的最短路径*/

		for(v = 1; v < G.getNumVertexes(); v++) {
			min = Map.INFINITY; //当前所知离v0顶点的最近距离

			for(w = 0; w < G.getNumVertexes(); w++) {//寻找离v0最近的顶点
				if( finalPath[w] != 1 && shortPathTable[w] < min) {
					k = w;
					min = shortPathTable[w];//w顶点离v0顶点更近
				}
			}


			finalPath[k] = 1;//将目前找到的最近的顶点置为1
			for(w = 0; w < G.getNumVertexes(); w++) {//修正当前路径长度
				if(finalPath[w] != 1 && (min + G.getArc(k, w) < shortPathTable[w]) ) {
					shortPathTable[w] = min + G.getArc(k, w);
					patharc[w] = k;
				}
			}
		}


	}

	public String printPath(String s) {//返回从起始点到s的最短路径
		int firstindex = G.getIndexof(s);//储存s的索引，之后需要路径长度
		int index = firstindex;
		LinkedList<String> namePath = new LinkedList<String>();//双向链表方便插入

		namePath.addFirst(G.getvexs(index));
		while(index != v0) {//每次将路径上的点插入到表头，得到倒叙（正确）路径
			index = patharc[index];
			namePath.addFirst(G.getvexs(index));
		}

		return namePath.toString() +"  " + "路程为  " + shortPathTable[firstindex] + "米";
	}

}