# Graph for Java

## DFS(depth first search)ͼ��������ȱ���

<img src="./dfs.png" width="600px" height="400px"/>

```
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
```
## DFS Test
### Test Code
```
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

``` 
### DFS Test Log
```
�������㣺0
�������㣺1
�������㣺2
�������㣺3
�������㣺4
�������㣺5
�������㣺6
�������㣺7
�������㣺8
```

## BFS(broad first search)������ȱ���
```
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

```
```
�������㣺0
�������㣺1
�������㣺5
�������㣺4
�������㣺6
�������㣺7
�������㣺3
�������㣺2
�������㣺8
```

## ʹ������ķ�㷨ʵ��ͼ����С������
```
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
```