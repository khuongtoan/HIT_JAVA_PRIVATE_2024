import java.util.Scanner;

public class MAin {
	public static void main(String[] args) {

		Application bookList = new Application();
		Scanner sc = new Scanner(System.in);

		bookList.addBook(new Book(1, "Giáo Khoa Toán", 2020, "Sách toán học cơ bản cho học sinh.", 50000));
		bookList.addBook(new Book(2, "Cổ Tích Việt Nam", 2018, "Tuyển tập các câu chuyện cổ tích Việt Nam.", 70000));
		bookList.addBook(new Book(3, "Khoa Học Thường Thức", 2021, "Giới thiệu kiến thức khoa học đời sống.", 85000));
		bookList.addBook(
				new Book(4, "Lập Trình Java", 2019, "Hướng dẫn lập trình Java từ cơ bản đến nâng cao.", 120000));
		bookList.addBook(new Book(5, "Văn Học Hiện Đại", 2022, "Tuyển tập các tác phẩm văn học hiện đại.", 95000));

		while (true) {
			System.out.println("\nChọn một trong các chức năng sau: \n" + "\t1 Thêm sách mới\n"
					+ "\t2 Chỉnh sửa thông tin sách\n" + "\t3 In ra danh sách các cuốn sách có trong mảng\n"
					+ "\t4 In ra cuốn sách lâu đời cổ kính nhất\n"
					+ "\t5 In ra cuốn sách phù hợp với giá tiền người mua yêu cầu\n"
					+ "\t6 Sắp xếp lại danh sách các cuốn sách( theo tên hoặc theo giá tiền)\n" + "\t7 thoát");

			int mn = sc.nextInt();
			switch (mn) {
			case 1:
				Book b = new Book();

				System.out.print("Nhập mã sách: ");
				int maSach = sc.nextInt();
				b.setMaSach(maSach);
				sc.nextLine();

				System.out.print("Nhập tên sách: ");
				String tenSach = sc.nextLine();
				b.setTenSach(tenSach);

				System.out.print("Nhập năm sản xuất: ");
				int namsx = sc.nextInt();
				b.setNamSX(namsx);
				sc.nextLine();

				System.out.print("Nhập tóm tắt nội dung: ");
				String content = sc.nextLine();
				b.setTomTatNoiDung(content);

				System.out.print("Nhập giá tiền: ");
				double cost = sc.nextDouble();
				b.setGiaTien(cost);

				bookList.addBook(b);

				break;
			case 2:
				bookList.updateBookInfoById();
				break;
			case 3:
				bookList.printBookList();
				break;
			case 4:
				bookList.printAncientBooks();
				break;
			case 5:
				System.out.println("Giá tiền sách bạn muốn mua: ");
				double price = sc.nextDouble();
				System.out.println("Tôi thấy quyển sách này phù hợp với túi tiền của bạn: ");
				bookList.suitableBook(price);

				break;
			case 6:
				System.out.println("Bạn muốn sắp xếp theo(1:tên|2:giá): ");
				int choose = sc.nextInt();
				sc.nextLine();
				if (choose == 1) {
					System.out.println("Bạn muốn sắp giảm dần không( yes|no): ");
					String input = sc.next();
					boolean flag = false;
					if (input.equalsIgnoreCase("yes")) {
						flag = true;
					}
					bookList.sortByName(flag);
					bookList.printBookList();

				} else {
					System.out.println("Bạn muốn sắp giảm dần không( yes|no): ");
					String input = sc.next();
					boolean flag = false;
					if (input.equalsIgnoreCase("yes")) {
						flag = true;
					}
					bookList.sortByCost(flag);
					bookList.printBookList();
				}

				break;
			case 7:
				System.out.println("đã thoát chương trình!");
				System.exit(0);

			}
		}

	}

}
