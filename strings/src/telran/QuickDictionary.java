package telran;

import java.util.HashMap;
import java.util.Map;

public class QuickDictionary {
	private Node rootNode = new Node();

	public String put(String key, String value) {
		var chars = key.toCharArray();
		var curNode = rootNode;

		for (char ch : chars) {
			if (ch < 65 || ch > 90) {
				throw new IllegalArgumentException();
			}
			curNode.lookup.putIfAbsent(ch, new Node());
			curNode = curNode.lookup.get(ch);
		}
		String prev = curNode.dictionaryVal;
		curNode.dictionaryVal = value;
		return prev;
	}

	public String get(String key) {
		var chars = key.toCharArray();
		var curNode = rootNode;

		for (char ch : chars) {
			if (ch < 65 || ch > 90) {
				throw new IllegalArgumentException();
			} else if (curNode.lookup.containsKey(ch)) {
				curNode = curNode.lookup.get(ch);
			} else {
				return null;
			}
		}
		return curNode.dictionaryVal;
	}

	private class Node {
		Map<Character, Node> lookup = new HashMap<>();
		String dictionaryVal;
	}
}