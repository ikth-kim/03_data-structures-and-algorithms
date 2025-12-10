package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/* 너비 우선 탐색 (Breadth-First Search, BFS)
* - Queue(FIFO, 선입선출)를 활용
* - 시작 노드에서 출발해서
*   시작 노드 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘이다.
* - 최단 경로를 찾을 때 적합
* */
public class B_BFS {

  // 배추밭의 크기를 저장할 변수
  static int M; // 가로 길이
  static int N; // 세로 길이
  static int K; // 배추(노드)의 개수

  // 배추밭을 나타낼 인접행렬(2차원 배열)
  static int[][] map;

  // 각 위치의 방문 여부를 저장할 배열
  static boolean[][] visit;

  // 필요한 지렁이 마릿수
  static int count;

  // 현재 노드 기준으로 상, 하, 좌, 우 이동을 위한 값을 배열로 초기화
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  /**
   *  노드의 x,y 좌표를 저장하는 클래스
   *  -> Queue에 담겨질 객체
   */
  static class Node{
    int x; // x 좌표(가로)
    int y; // y 좌표(세로)

    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }

  // 현재 탐색 중인 좌표를 저장할 변수(상하좌우 이동한 좌표가 저장됨)
  static int cx, cy;

  // BFS 방식으로 해결하기 위한 Queue 생성
  static Queue<Node> q = new LinkedList<>();


  /**
   * 배추밭에 필요한 지렁이의 수를 구하는 메서드
   * @param input 입력 데이터(배추밭 크기, 배추 개수, 배추 위치)
   * @return 필요한 지렁이의 수
   * @throws IOException
   */
  public static int solution(String input) throws IOException{

    BufferedReader br = new BufferedReader(new StringReader(input));

    // 첫 번째 줄 (가로 세로 개수)을 읽어와 토큰화
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken()); // 가로
    N = Integer.parseInt(st.nextToken()); // 세로
    K = Integer.parseInt(st.nextToken()); // 개수

    // 배추밭 map, visit 초기화
    map = new int[M][N];
    visit = new boolean[M][N];

    // 배추밭에 배추 심기
    for(int i = 0 ; i < K ; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()); // x 좌표
      int y = Integer.parseInt(st.nextToken()); // y 좌표
      map[x][y] = 1; // 배추 심기
    }

    // 배추밭 출력하기
    System.out.println("[[배추밭]]");
    for(int i = 0 ; i < M ; i++){
      for(int j = 0 ; j < N ; j++ ){
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();



    return 0;
  }

}
