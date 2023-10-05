class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length; //size of the array
        List<Integer> result = new ArrayList<>(); // list of answers

        for (int i = 0; i < n; i++) {
            //selected element is arr[i]:
            // Checking if arr[i] is not already
            // a part of the answer:
            if (result.size() == 0 || result.get(0) != arr[i]) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    // counting the frequency of arr[i]
                    if (arr[j] == arr[i]) {
                        count++;
                    }
                }

                // check if frequency is greater than n/3:
                if (count > (n / 3))
                    result.add(arr[i]);
            }

            if (result.size() == 2) break;
        }

        return result;
    }
}