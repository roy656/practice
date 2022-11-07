package com.example.practice.data_structure.linked_list;

public class MyLinkedList {             // LinkedList 에서는 데이터를 조작할때 원하는 곳의 이전 노드를 알아야 한다.

    private MyListNode head;            // LinkedList 의 맨 앞 노드
    int count;

    public MyLinkedList() {
        head = null;
        count = 0;
    }

    public MyListNode addElement(String data) {
        MyListNode newNode;

        if(head == null) {
            newNode = new MyListNode(data);
            head = newNode;

        } else {
            newNode = new MyListNode(data);

            MyListNode temp = head;
            while ( temp.next != null) {        // head 부터 다음,다음 노드를 따라 마지막 노드까지 간다음 새 노드 추가.
                temp = temp.next;
            }
            temp.next = newNode;
        }

        count++;

        return newNode;
    }

    public MyListNode inserElement(int position, String data) {

        int i;
        MyListNode tempNode = head;
        MyListNode preNode = null;

        MyListNode newNode = new MyListNode(data);

        if(position<0 || position>count) {
            return null;
        }

        if(position ==0) {          // 넣을 곳이 맨 앞 일 경우
            newNode.next = head;    // 맨앞이었던 head 가 2번째가 되고
            head = newNode;         // 이제 newNode 가 head 가 된다
        }

        else {                                  // 넣는 곳이 중간일 경우
            for(i=0; i<position; i++) {
                preNode = tempNode;             // tempNode 를 head 로 어싸인 후
                tempNode = tempNode.next;       // 하나씩 다음으로 가면서 position 의 하나 전까지 돌아 preNode 의 위치 찾기
            }

            newNode.next = preNode.next;        // preNode 의 다음이었던 자리가 newNode 의 다음이 되고
            preNode.next = newNode;             // 결과적으로 newNode 는 이전 노드의 다음으로 어싸인.
        }

        count++;
        return newNode;
    }

    public MyListNode removeElement(int position) {

        int i;
        MyListNode tempNode = head;
        MyListNode preNode = null;

        if(position == 0) {
            head = tempNode.next;
        } else {
            for(i=0; i<position; i++) {
                preNode = tempNode;
                tempNode = tempNode.next;
            }

            preNode.next = tempNode.next;
        }

        count--;
        return tempNode;
    }
}
