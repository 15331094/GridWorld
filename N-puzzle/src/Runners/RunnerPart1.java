package Runners;

import java.io.IOException;

import jigsaw.Jigsaw;
import jigsaw.JigsawNode;

public class RunnerPart1 {
	/**测试脚本-1
	 * 实验任务一：利用广度优先搜索，求指定3*3拼图（8-数码问题）的最优解
	 * 要求：不修改脚本内容，程序能够运行，且得出预期结果
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		int total = 0;
		int testTimes = 5000;
		int failTimes = 0;
		for (int i = 0; i < testTimes; i++) {
			// 检查节点维数是否为3
			if(JigsawNode.getDimension() != 3){
				System.out.print("节点维数不正确，请将JigsawNode类的维数dimension改为5");
				return;
			}
			
			// 生成目标状态destNode：{9,1,2,3,4,5,6,7,8,0}
			JigsawNode destNode = new JigsawNode(new int[]{9,1,2,3,4,5,6,7,8,0}); 
//			JigsawNode destNode = new JigsawNode(new int[]{2,1,0,2,7,5,4,6,3,8}); 
			JigsawNode startNode = Jigsaw.scatter(destNode, 1000);
		
			// 生成jigsaw对象：设置初始状态节点startNode和目标状态节点destNode
			Jigsaw jigsaw = new Jigsaw(startNode, destNode);
		
			// 执行启发式搜索示例算法
			jigsaw.ASearch();
			total += jigsaw.getSearchedNodesNum();
			String times;
			if (jigsaw.getSearchedNodesNum() > 5000) {
				times = "Can't find";
				failTimes++;
			}else{
				times = "" + jigsaw.getSearchedNodesNum();
			}
			System.out.println("The "+i+" times"+ "   " + times);
		}
		
		System.out.println("The average number of searched nodes for "+testTimes+" times is "+total/testTimes);
		System.out.println("Fail times: " + failTimes);
	}
	
}
