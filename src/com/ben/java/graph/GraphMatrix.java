package com.ben.java.graph;

import java.util.LinkedList;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/2/18
 * @desc ͼ���ڽӾ���洢��ʽ
 */
public class GraphMatrix {
    //��������
    private int vertexSize;
    //���㼯��
    private int vertexs[];
    //����
    public int vertexMatrix[][];

    private boolean[] visited;
    /**
     * ���Ȩֵ�߽�
     */
    public static final int MAX_WEIGHT = 99999;

    public int getVertexSize() {
        return vertexSize;
    }

    public int[][] getVertexMatrix() {
        return vertexMatrix;
    }

    public GraphMatrix(int vertexSize) {
        this.vertexSize = vertexSize;
        //init matrix
        visited = new boolean[vertexSize];
        vertexs = new int[vertexSize];
        vertexMatrix = new int[vertexSize][vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            vertexs[i] = i;
        }
    }

    /**
     * ��ȡ����ĳ���
     *
     * @param vertex
     * @return
     */
    public int getOutDegree(int vertex) {
        if (vertex >= vertexSize) {
            throw new IndexOutOfBoundsException();
        }
        int degree = 0;
        for (int i = 0; i < vertexMatrix[vertex].length; i++) {
            if (vertexMatrix[vertex][i] > 0 && vertexMatrix[vertex][i] < MAX_WEIGHT) {
                degree++;
            }
        }
        return degree;
    }

    /**
     * ��ȡ��������
     *
     * @param vertex
     * @return
     */
    public int getEnterDegree(int vertex) {
        if (vertex >= vertexSize) {
            throw new IndexOutOfBoundsException();
        }
        int degree = 0;
        for (int i = 0; i < vertexSize; i++) {
            if (vertexMatrix[i][vertex] > 0 && vertexMatrix[i][vertex] < MAX_WEIGHT) {
                degree++;
            }
        }
        return degree;
    }

    /**
     * ��ȡ��������֮���Ȩֵ
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getVertexWeight(int v1, int v2) {
        if (v1 >= vertexSize || v2 >= vertexSize) {
            throw new IndexOutOfBoundsException();
        }
        return vertexMatrix[v1][v2] <= 0 ? 0 : (vertexMatrix[v1][v2] >= MAX_WEIGHT ? -1 : vertexMatrix[v1][v2]);
    }

    /**
     * ��ȡָ����������ڶ���
     *
     * @param vertex
     * @return
     */
    private int getVertexNeighbor(int vertex) {
        for (int i = 0; i < vertexSize; i++) {
            if (vertexMatrix[vertex][i] > 0 && vertexMatrix[vertex][i] < MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }

    /**
     * ��ȡָ������v1�����v2֮��ĵ�һ������
     *
     * @param v1
     * @param v2
     * @return
     */
    private int getNextVertex(int v1, int v2) {
        //��V2��ʼ������������v2
        for (int i = v2 + 1; i < vertexSize; i++) {
            if (vertexMatrix[v1][i] > 0 && vertexMatrix[v1][i] < MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }

    /**
     * ������ȱ���<br>
     * �������ȱ�������A�ĵ�һ���ڽӵ㣬�����ѱ����ĵ㲻�ɱ��ظ����������ڽӵ������ɱ�������A�������ڵ㡣<br>
     * �ѱ��������Ķ��㲻����������
     *
     * @param startVertex
     */
    private void depthFirstSearch(int startVertex) {
        //��ǵ�ǰ�����ѱ�����
        visited[startVertex] = true;
        int vertex = getVertexNeighbor(startVertex);
        while (vertex != -1) {
            if (!visited[vertex]) {
                //�ö���δ��������
                System.out.println("�������㣺" + vertex);
                depthFirstSearch(vertex);
            }
            //������ǰ�����ͬ������
            vertex = getNextVertex(startVertex, vertex);
        }

    }

    /**
     * �����ṩ�����ӿڣ���ֹ���ֽڵ���ڱ������������
     */
    public void depthFirstSearch() {
        visited = new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            if (!visited[i]) {
                System.out.println("�������㣺" + i);
                depthFirstSearch(i);
            }
        }
    }

    /**
     * ������ȱ���
     */
    private void broadFirstSearch(int startVertex) {
        visited[startVertex] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        //��������������
        queue.addFirst(startVertex);
        //��������
        while (!queue.isEmpty()) {
            //����
            int a = queue.removeFirst();
            //���ȱ�������A
            int vertex = getVertexNeighbor(a);
            while (vertex != -1) {
                //�ж��Ƿ����
                if (!visited[vertex]) {
                    System.out.println("�������㣺" + vertex);
                    visited[vertex] = true;
                    //������У����б���ʱ������һ���
                    queue.addFirst(vertex);
                }
                vertex = getNextVertex(a, vertex);
            }

        }
    }

    public void broadFirstSearch() {
        visited = new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            if (!visited[i]) {
                System.out.println("�������㣺" + i);
                broadFirstSearch(i);
            }
        }
    }

    /**
     * ʹ������ķ�㷨ʵ��ͼ����С������<br>
     * [0,10,#,#,#,11,#,#,#]<br>
     * ������Сλ����λ��<br>
     * .�� i = 1(10)<br>
     * .�� ����sΪ<br>
     * [10,0,18,#,#,#,16,#,12]<br>
     * �滻��<br>
     */
    public void prim() {
        //��СȨֵ����
        int[] lowcost = new int[vertexSize];
        int[] weights = new int[vertexSize];
        int min, minId, weightSum = 0;

        //������СȨֵ����
        for (int i = 0; i < vertexSize; i++) {
            lowcost[i] = vertexMatrix[0][i];
        }

        //������СȨֵ��������С����λ
        for (int j = 1; j < vertexSize; j++) {
            min = MAX_WEIGHT;
            minId = 0;
            for (int i = 1; i < vertexSize; i++) {
                if (lowcost[i] < min && lowcost[i] > 0) {
                    min = lowcost[i];
                    minId = i;
                }
            }
            //��������λ������СȨֵ�е����ݱȽ�
            //��������λ�ñ�
            lowcost[minId] = 0;
            weightSum += min;
            for (int i = 1; i < vertexSize; i++) {
                if (vertexMatrix[minId][i] < lowcost[i] && lowcost[i] > 0) {
                    lowcost[i] = vertexMatrix[minId][i];
                    weights[i] = minId;
                }
            }
        }

        System.out.println("��С������Ȩֵ�ͣ�" + weightSum);
    }


}
