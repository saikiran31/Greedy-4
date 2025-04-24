class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int sl = source.length();
        int tl = target.length();

        for (int i = 0; i < sl; i++) {
            char ch = source.charAt(i);
            if (!map.containsKey(ch)) { 
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i); // Add index to the list
        }

        int cnt = 1; // Count of source passes
        int sp = 0;  // Pointer in source
        int tp = 0;  // Pointer in target

        while (tp < tl) {
            char tchar = target.charAt(tp);

            if (!map.containsKey(tchar)) {
                return -1;
            }

            List<Integer> li = map.get(tchar);

            int bsIdx = binarySearch(li, sp);

            if (bsIdx == -1) {
                cnt++;
                sp = 0;
                continue; // Re-try matching this target character
            } else {
                // Found index in source
                sp = li.get(bsIdx) + 1;
                tp++; // Move to next character in target
            }
        }

        return cnt;
    }

    // Find the first index in list ≥ sid using binary search
    private int binarySearch(List<Integer> li, int sid) {
        int low = 0;
        int high = li.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (li.get(mid) >= sid) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}

//tc: O(s + t * log s)
//sc: O(s)
