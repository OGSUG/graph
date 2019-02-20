package com.ben.java.graph;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/2/20
 * @desdc �Ͻ�˹�����㷨ʵ��ͼ�����·��
 */
public class GraphDijkstraShortPath {
    private boolean[] visited;

    /**
     * ʹ�õϽ�˹�����㷨����ͼ�е����·��
     *
     * @param graphMatrix
     */
    public void shortestPath(GraphMatrix graphMatrix) {
        if (graphMatrix == null) {
            throw new NullPointerException();
        }
        visited = new boolean[graphMatrix.getVertexSize()];
        //���·������
        int[] shortestPath = new int[graphMatrix.getVertexSize()];
        //��ע��ǰ����λ��
        int min = GraphMatrix.MAX_WEIGHT;
        int minId = 0;
        //��ʼ�����·������
        for (int i = 0; i < graphMatrix.getVertexSize(); i++) {
            shortestPath[i] = graphMatrix.getVertexMatrix()[0][i];
        }
        //�����Ϊ��0������
        shortestPath[0] = 0;
        //���������и�������
        for (int i = 0; i < graphMatrix.getVertexSize(); i++) {
            min = GraphMatrix.MAX_WEIGHT;
            //�����·�������в�����С�����,���ѱ������ĵ㲻�ɱ��ظ�����
            for (int j = 1; j < graphMatrix.getVertexSize(); j++) {
                if (shortestPath[j] < min && !visited[j]) {
                    min = shortestPath[j];
                    minId = j;
                }
            }
            //��Ƕ���ΪminId�ĵ��ѱ�����
            visited[minId] = true;
            //�ڶ���ΪminId�ĵ��н��бȽϣ�������·�������е�Vx+Vy>Vx ���滻���·���е�VxΪVy
            for (int j = 0; j < graphMatrix.getVertexSize(); j++) {
                if (!visited[j] && (min + graphMatrix.getVertexMatrix()[minId][j]) < shortestPath[j]) {
                    //replace
                    shortestPath[j] = min + graphMatrix.getVertexMatrix()[minId][j];
                }
            }


        }

        for (int i = 0; i < shortestPath.length; i++) {
            System.out.println("����V0 --> V" + i + "���·��Ϊ��" + shortestPath[i]);
        }

    }

    /**
     * ʹ�õϽ�˹�����㷨����ͼ�е����·������¼·����
     *
     * @param graphMatrix
     */
    public void shortestPath2(GraphMatrix graphMatrix) {
        if (graphMatrix == null) {
            throw new NullPointerException();
        }
        visited = new boolean[graphMatrix.getVertexSize()];
        //���·������
        Path[] shortestPath = new Path[graphMatrix.getVertexSize()];
        //·�����㼯��
        List<Integer> vertexs = new ArrayList<>();
        //��ע��ǰ����λ��
        int min = GraphMatrix.MAX_WEIGHT;
        int minId = 0;
        //��ʼ�����·������
        for (int i = 0; i < graphMatrix.getVertexSize(); i++) {
            Path path = new Path();
            path.setWeight(graphMatrix.getVertexMatrix()[0][i]);
            path.setStart(0);
            path.setEnd(i);
            shortestPath[i] = path;
        }

        //���������и�������
        for (int i = 0; i < graphMatrix.getVertexSize(); i++) {
            min = GraphMatrix.MAX_WEIGHT;
            //�����·�������в�����С�����,���ѱ������ĵ㲻�ɱ��ظ�����
            for (int j = 1; j < graphMatrix.getVertexSize(); j++) {
                if (shortestPath[j].getWeight() < min && !visited[j]) {
                    min = shortestPath[j].getWeight();
                    minId = j;
                }
            }
            //��Ƕ���ΪminId�ĵ��ѱ�����
            visited[minId] = true;
            vertexs.add(minId);
            //�ڶ���ΪminId�ĵ��н��бȽϣ�������·�������е�Vx+Vy>Vx ���滻���·���е�VxΪVy
            for (int j = 0; j < graphMatrix.getVertexSize(); j++) {
                if (!visited[j] && (min + graphMatrix.getVertexMatrix()[minId][j]) < shortestPath[j].getWeight()) {
                    //replace
                    shortestPath[j].setWeight(min + graphMatrix.getVertexMatrix()[minId][j]);
                    shortestPath[j].getPaths().clear();
                    shortestPath[j].getPaths().addAll(vertexs);
                    //��������յ�
                    shortestPath[j].getPaths().addFirst(shortestPath[j].getStart());
                    shortestPath[j].getPaths().addLast(shortestPath[j].getEnd());
                }
            }


        }

        for (int i = 0; i < shortestPath.length; i++) {
            System.out.println("��ʼ����" + shortestPath[i].getStart() + " --> V" + i + "���·��ȨֵΪ��" + shortestPath[i].getWeight() + "  ·��Ϊ��" + Arrays.toString(shortestPath[i].getPaths().toArray()));
        }
    }

    class Path {
        int start;
        int end;
        int weight;
        LinkedList<Integer> paths = new LinkedList<>();

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public LinkedList<Integer> getPaths() {
            return paths;
        }

        public void setPaths(LinkedList<Integer> paths) {
            this.paths = paths;
        }
    }


}
