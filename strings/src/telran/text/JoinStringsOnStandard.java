package telran.text;

public class JoinStringsOnStandard implements JoinStrings {

	@Override
	public String join(String[] strings, String delimiter) {
		if (strings != null && strings.length > 0) {
			return String.join(delimiter, strings);
		}
		return "";
	}

}
