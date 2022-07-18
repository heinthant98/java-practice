import java.time.LocalDate;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<User> users = List.of(
				new User("佐藤美咲", LocalDate.of(1990, 1, 1)),
				new User("鈴木太郎", LocalDate.of(1991, 2, 2)),
				new User("山田一郎", LocalDate.of(2003, 3, 3)),
				new User("鈴木花子", LocalDate.of(2002, 4, 4)));
		
		System.out.println("【すべてのユーザーを表示する】");
		users.forEach(u -> System.out.println("名前: %s, 生年月日: %s".formatted(u.getName(),u.getBirthDate())));
	}

}
