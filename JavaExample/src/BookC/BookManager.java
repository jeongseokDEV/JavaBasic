package BookC;

import java.util.Scanner;

public class BookManager {
	
    Scanner sc = new Scanner(System.in);
    Book[] books = new Book[100];
    
    boolean isRun = true;
    int selectNo = 0;
    int count = 1;
    
    public BookManager()
    {
        run();
    }
    
    //�ʱ�ȭ�� �޼ҵ�
    public void run()
    {
        while(isRun)
        {
            System.out.println("============================================================");
            System.out.println("1. ������� | 2. ������� | 3. �������� | 4. �������� | 5. ����");
            System.out.println("============================================================");
            selectNo = getSelectNum("��ȣ�� �����ϼ��� > ");
            
            switch(selectNo)
            {
            case 1 :
                registerBook();
                break;
            case 2 :
                selectBook();
                break;
            case 3 :
                updateBook();
                break;
            case 4 :
                deleteBook();
                break;
            case 5 : 
                terminate();
                break;
            default : 
                    System.out.println("��ϵ� �޴��� �ƴմϴ�.");
            }
            
        }
    }
    
    public void terminate() {
        System.out.println("���α׷� ����");
        isRun = false;
    }
    
    //������� �޼ҵ�
    public void registerBook()
    {
        System.out.println("1.�������");
        String title = getData("����� ������ ������ �Է����ּ���  :");
        String author = getData("����� ������ ���ڸ� �Է����ּ��� : ");
        
        for(int i = 0; i < books.length; i++)
        {
            if(books[i] == null)
            {
                count = i+1;//Count�� ��ϵ� ���� ��ȣ.
                books[i] = new Book(count,title,author);
                System.out.println("��ϿϷ�");
                break;
            }
        }
    }
    
    //���� ��� �޼ҵ�
    public void selectBook()
    {
        System.out.println("2.�������");
        for(Book b : books)
        {
            if( b != null )
            {
                printBookInfo(b);
            }
        }
    }
    
    //���� ���� �޼ҵ�
    public void updateBook()
    {
        System.out.println("3. ��������");
        int bookNum = getSelectNum("������ ������ ���� ��ȣ�� �Է��ϼ��� > ");
        
        Book b = findBook(bookNum);
        if(b == null)
        {
            System.out.println("�Է��Ͻ� ������ȣ�� å�� �������� �ʽ��ϴ�.");
            return;
        }
        
        boolean isUpdate = true;
        
        while(isUpdate) 
        {
            System.out.println("====================================================");
            System.out.println("1. ������� | 2. ���ڼ��� | 3. �����Ϸ�");
            System.out.println("====================================================");
            
            selectNo = getSelectNum("��ȣ�Է� >>");
            
            switch(selectNo)
            {
            case 1 :
                String title = getData("������ �������ּ��� >>");
                b.setTitle(title);
                System.out.println("���� ���� �Ϸ� ");
                
            case 2 : 
                String author = getData("���� �̸��� �������ּ��� >>");
                b.setAuthor(author);
                System.out.println("���� �̸� �����Ϸ�");
            case 3 :
                System.out.println("�����޴� ����");
                isUpdate = false;
                break;
            }
        }
    }
    
    //���� ���� �޼ҵ�
    public void deleteBook()
    {
        System.out.println("4. ��������");
        int bookNum = getSelectNum("������ ������ ������ȣ�� �Է��ϼ���.");
        
        Book b = findBook(bookNum);
        
        if(b == null)
        {
            System.out.println("�Է��Ͻ� ������ȣ�� å�� �������� �ʽ��ϴ�.");
            return;
        }
        
        for(int i = 0; i < books.length; i++)
        {
            if(books[i] != null && books[i].getNum() == bookNum)
            {
                books[i] = null;
                System.out.println("���� �Ϸ�");
                return;
            }
        }
    }
    
    //å ������ �ҷ���.
    public void printBookInfo(Book b)
    {
        System.out.println(b.toString());
    }
    
    //num�� �ش��ϴ� å�� �ҷ���.
    public Book findBook(int num)
    {
        for(int i = 0; i< books.length; i++)
        {
            if(books[i] != null && books[i].getNum() == num)
            {
                return books[i];
            }
        }
        
        return null;
    }
    //å�� ������ �Է�.
    String getData(String message)
    {
        System.out.println(message);
        return sc.next();
    }
    
    //å 
    int getSelectNum(String message)
    {
        System.out.println(message);
        return sc.nextInt();
    }
    
    //MAIN
    public static void main(String[] args)
    {
        new BookManager();
    }
}