import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<User> users = List.of(
				new User("佐藤美咲", LocalDate.of(1990, 1, 1)),
				new User("鈴木太郎", LocalDate.of(1991, 2, 2)), 
				new User("山田一郎", LocalDate.of(2003, 3, 3)),
				new User("鈴木花子", LocalDate.of(2002, 4, 4)));

		System.out.println("【すべてのユーザーを表示する】");
		users.forEach(u -> System.out.println("名前: %s, 生年月日: %s".formatted(u.getName(), u.getBirthDate())));

		System.out.println("【すべてのユーザーを表示する。ただし生年月日はyyyy/MM/dd(E)形式で出力する】");
		users.forEach(u -> System.out.println("名前: %s, 生年月日: %s".formatted(u.getName(), toJapaneseFormat(u.getBirthDate()))));

		System.out.println("【名前が鈴木で始まる人のみを表示する】");
		users.stream().filter(user -> user.getName().startsWith("鈴木")).forEach(u -> System.out.println(u.getName()));

		System.out.println("【生年月日が2000年1月1日以降の人のみを表示する");
		users.stream().filter(u -> u.getBirthDate().getYear() > 2000)
				.forEach(u -> System.out.println("名前: %s, 生年月日: %s".formatted(u.getName(), u.getBirthDate())));

		System.out.println("【生年月日の昇順に並び替えて表示する】");
		users.stream().sorted(Comparator.comparing(User::getBirthDate))
				.forEach(u -> System.out.println("名前: %s, 生年月日: %s".formatted(u.getName(), u.getBirthDate())));

		System.out.println("【生年月日の降順に並び替えて表示する】");
		users.stream().sorted(Comparator.comparing(User::getBirthDate).reversed())
				.forEach(u -> System.out.println("名前: %s, 生年月日: %s".formatted(u.getName(), u.getBirthDate())));

}

	private static String toJapaneseFormat(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日(E)"));
	}

}
