package mini_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		Reader fr = new FileReader("phoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);

		List<Friend> list = new ArrayList<Friend>();

		while (true) {
			String str = "";
			str = br.readLine();
			if (str == null) {
				break;
			}
			String[] friend_member = str.split(",");

			list.add(new Friend(friend_member[0], friend_member[1], friend_member[2]));

		}

		System.out.println("==================================");
		System.out.println("****    전 화 번 호 관 리 프 로 그 램            ****");
		System.out.println("==================================");
		while (true) {

			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료  ");

			int select_number = sc.nextInt();

			switch (select_number) {
			case 1:
				for (int i = 0; i < list.size(); i++) {
					System.out.print((i + 1) + ": ");
					list.get(i).showInfo();
				}
				break;
			case 2:
				System.out.println("정보를 입력해주세요: ");
				String friend_insert = sc2.nextLine();
				String friend_list[] = friend_insert.split(" ");
				Friend friend_add = new Friend(friend_list[0], friend_list[1], friend_list[2]);
				list.add(friend_add);

				BufferedWriter bw = new BufferedWriter(new FileWriter("PhoneDB.txt"));

				while (true) {
					for (int i = 0; i < list.size(); i++) {
						bw.write(list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getCompany());
						bw.newLine();
					}
					break;
				}

				bw.close();
				break;

			case 3:

				System.out.print("삭제하고 싶은 번호를 입력해주세요: ");
				int select_Number = sc3.nextInt();
				if (select_Number <= list.size()) {
					list.remove(select_Number - 1);
					System.out.println("정보가 삭제되었습니다.");
					break;
				} else {
					System.out.println("잘못된 번호입니다. 다시 입력해주세요.");

				}

			case 4:
				System.out.print("찾고싶은 문자열을 입력하세요: ");
				String search_String = sc4.nextLine();

				while (true) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getName().contains(search_String)) {
							list.get(i).showInfo();

						}
					}
					break;
				}
				break;
			case 5:
				System.out.println("시스템을 종료합니다.");
				sc.close();
				sc2.close();
				sc3.close();
				sc4.close();
				br.close();
				System.exit(0);
				
				break;

			default:
				System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요");
				break;

			}

		}
	}
}
