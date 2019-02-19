package com.ben.java.graph;

import static com.ben.java.graph.GraphMatrix.MAX_WEIGHT;

public class Test {
    public static void main(String args[]) {
        DFS();
        BFS();

    }
    public static void graphMatrix() {
        GraphMatrix graphMatrix = new GraphMatrix(5);
        int[] v0 = new int[]{0, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 6};
        int[] v1 = new int[]{9, 0, 3, MAX_WEIGHT, MAX_WEIGHT};
        int[] v2 = new int[]{2, MAX_WEIGHT, 0, 5, MAX_WEIGHT};
        int[] v3 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0, 1};
        int[] v4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};

        graphMatrix.vertexMatrix[0] = v0;
        graphMatrix.vertexMatrix[1] = v1;
        graphMatrix.vertexMatrix[2] = v2;
        graphMatrix.vertexMatrix[3] = v3;
        graphMatrix.vertexMatrix[4] = v4;

        System.out.println("����V2�ĳ��ȣ�" + graphMatrix.getOutDegree(2));
        System.out.println("����V0����ȣ�" + graphMatrix.getEnterDegree(0));
        System.out.println("����V1��V0��Ȩֵ��" + graphMatrix.getVertexWeight(1, 0));
    }

    /**
     * depth first search��ȱ���
     */
    public static void DFS() {

        GraphMatrix graph = new GraphMatrix(9);

        int [] a1 = new int[]{0,10,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,11,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
        int [] a2 = new int[]{10,0,18,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,16,MAX_WEIGHT,12};
        int [] a3 = new int[]{MAX_WEIGHT,MAX_WEIGHT,0,22,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,8};
        int [] a4 = new int[]{MAX_WEIGHT,MAX_WEIGHT,22,0,20,MAX_WEIGHT,MAX_WEIGHT,16,21};
        int [] a5 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,20,0,26,MAX_WEIGHT,7,MAX_WEIGHT};
        int [] a6 = new int[]{11,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,26,0,17,MAX_WEIGHT,MAX_WEIGHT};
        int [] a7 = new int[]{MAX_WEIGHT,16,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,17,0,19,MAX_WEIGHT};
        int [] a8 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,16,7,MAX_WEIGHT,19,0,MAX_WEIGHT};
        int [] a9 = new int[]{MAX_WEIGHT,12,8,21,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0};

        graph.vertexMatrix[0] = a1;
        graph.vertexMatrix[1] = a2;
        graph.vertexMatrix[2] = a3;
        graph.vertexMatrix[3] = a4;
        graph.vertexMatrix[4] = a5;
        graph.vertexMatrix[5] = a6;
        graph.vertexMatrix[6] = a7;
        graph.vertexMatrix[7] = a8;
        graph.vertexMatrix[8] = a9;

        graph.depthFirstSearch();
    }

    /**
     * broad first search��ȱ���
     */
    public static void BFS() {
        GraphMatrix graph = new GraphMatrix(9);

        int [] a1 = new int[]{0,10,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,11,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
        int [] a2 = new int[]{10,0,18,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,16,MAX_WEIGHT,12};
        int [] a3 = new int[]{MAX_WEIGHT,MAX_WEIGHT,0,22,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,8};
        int [] a4 = new int[]{MAX_WEIGHT,MAX_WEIGHT,22,0,20,MAX_WEIGHT,MAX_WEIGHT,16,21};
        int [] a5 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,20,0,26,MAX_WEIGHT,7,MAX_WEIGHT};
        int [] a6 = new int[]{11,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,26,0,17,MAX_WEIGHT,MAX_WEIGHT};
        int [] a7 = new int[]{MAX_WEIGHT,16,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,17,0,19,MAX_WEIGHT};
        int [] a8 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,16,7,MAX_WEIGHT,19,0,MAX_WEIGHT};
        int [] a9 = new int[]{MAX_WEIGHT,12,8,21,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0};

        graph.vertexMatrix[0] = a1;
        graph.vertexMatrix[1] = a2;
        graph.vertexMatrix[2] = a3;
        graph.vertexMatrix[3] = a4;
        graph.vertexMatrix[4] = a5;
        graph.vertexMatrix[5] = a6;
        graph.vertexMatrix[6] = a7;
        graph.vertexMatrix[7] = a8;
        graph.vertexMatrix[8] = a9;

        graph.broadFirstSearch();

        graph.prim();
    }
}
