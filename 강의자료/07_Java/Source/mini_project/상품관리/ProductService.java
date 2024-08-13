package chap14.sec04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProductService {
	List<Product> lists = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	private int counter;
	private String confFileName ="D:\\kdt_2024\\WorkSpace\\java_eclipse\\chap01\\src\\chap14\\sec04\\data.txt";
	
	public void showMenu() {
		
		readConf();
		while(true) {
			System.out.println("---------------------------------------------------");
			System.out.println("1.등록  |  2.목록   |  3.입고   | 4.판매   5.매출정보  0.종료");
			System.out.println("---------------------------------------------------");
			
			System.out.print("선택: ");
			String selectNo = scanner.nextLine();
			switch(selectNo) {
				case "1": registerProduct(); break;
				case "2": showProducts(); break;
				case "3" : ipgoProduct(); break;
				case "0": return;
			}
		}
	}
	public void registerProduct() {
		try {
			Product product = new Product();
			
			System.out.print("상품번호: ");
			product.setPno(Integer.parseInt(scanner.nextLine().trim()));
			
			System.out.print("상품명: ");
			product.setName(scanner.nextLine());
			
			System.out.print("가격: ");
			product.setPrice(Integer.parseInt(scanner.nextLine()));
			
			System.out.print("재고: ");
			product.setStock(Integer.parseInt(scanner.nextLine()));
			
			lists.add(product);
			
		} catch(Exception e) {
			System.out.println("등록 에러: " + e.getMessage());
		}
	}
	
	public void showProducts() {
		System.out.println("상품코드\t상품명\t단가\t재고\t판매수량");
		System.out.println("-----------------------------------");
		for(Product p : lists) {
			System.out.println(p.getPno() + "\t" + p.getName() + "\t" + p.getPrice() + "\t" + p.getStock()+"\t" + p.getSale());
		}
		System.out.println();
	}
	public void ipgoProduct() {
		try {
			System.out.print("상품코드를 입력하시오 :");
			Product  product = findProductIndex( scanner.nextLine());
			if ( product == null ) {
				System.out.println("상품이 없습니다..");
				return;
			}
			System.out.print("수량을 입력하시오 :");
			int nProductCount = convertToInt(scanner.nextLine());
			product.setStock(product.getStock() + nProductCount);
			
		}catch (Exception e) {
			
		}
	}
	public Product findProductIndex(int nPno) {
		int nCount  = 0;
		for(Product p : lists) {
			if ( nPno == p.getPno())
				return p;
			nCount++;
		}
		return null;
				
	}
	public Product findProductIndex(String strPno) {
		return 	findProductIndex(convertToInt(strPno));			
	}
	public void readConf()  {
		try {
			FileReader fis = new FileReader(confFileName);
			BufferedReader reader  = new BufferedReader(fis);
			String str;
			while ( ( str=reader.readLine()) != null ) {
				StringTokenizer st = new StringTokenizer(str,",");
				if ( st.countTokens() == 5 ) {
					Product pd = new Product();
					pd.setPno( convertToInt( st.nextToken()));
					pd.setName(st.nextToken().trim());
					pd.setPrice( convertToInt( st.nextToken()) );
					pd.setStock( convertToInt( st.nextToken()) );
					pd.setSale( convertToInt( st.nextToken()) );
						
					lists.add(pd);
				}
			}
			fis.close();
		}catch( Exception e) {
			System.out.println("읽기 오류 : "+ e);
		}
	}
	public int convertToInt( String str) {
		int nVal  ;
		try {
			nVal = Integer.parseInt(str.trim());
		}catch ( Exception e) {
			return -1;
		}
		return nVal;
	}
}
