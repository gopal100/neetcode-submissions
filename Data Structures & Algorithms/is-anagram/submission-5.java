class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> first = new HashMap<>();
		Map<Character, Integer> second = new HashMap<>();

		for (Character ch : s.toCharArray()) {
			first.put(ch, first.getOrDefault(ch, 0)+1);
		}
		for (Character ch : t.toCharArray()) {
			second.put(ch, second.getOrDefault(ch, 0)+1);
		}

        if (first.size() != second.size()) {
			return false;
		}

		for (Map.Entry<Character, Integer> entrySet : first.entrySet()) {
			if (!Objects.equals(entrySet.getValue(), second.get(entrySet.getKey()))) {
				return false;
			}
		}
		return true;
    }
}
