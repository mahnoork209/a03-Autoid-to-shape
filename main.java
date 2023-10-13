import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

abstract class Shape {
    private static int shapeCounter = 0;
    private int shapeID;
    private LocalDateTime creationTime;

    public Shape() {
        this.shapeID = ++shapeCounter;
        this.creationTime = LocalDateTime.now();
    }

    public int getShapeID() {
        return shapeID;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    abstract void draw();

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Shape ID: " + shapeID + ", Created at: " + creationTime.format(formatter);
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a square");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a triangle");
    }
}

class LinkedListNode {
    private Shape shape;
    private LinkedListNode next;

    public LinkedListNode(Shape shape) {
        this.shape = shape;
        this.next = null;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}

class ShapeLinkedList {
    private LinkedListNode head;

    public ShapeLinkedList() {
        this.head = null;
    }

    public void addShape(Shape shape) {
        LinkedListNode newNode = new LinkedListNode(shape);
        if (head == null) {
            head = newNode;
        } else {
            LinkedListNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void drawAllShapes() {
        LinkedListNode current = head;
        while (current != null) {
            current.getShape().draw();
            current = current.getNext();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeLinkedList shapeList = new ShapeLinkedList();

        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                shapeList.addShape(new Square());
            } else if (i % 3 == 1) {
                shapeList.addShape(new Rectangle());
            } else {
                shapeList.addShape(new Triangle());
            }
        }

        shapeList.drawAllShapes();
    }
}