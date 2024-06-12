class Solution {
public:
    void sortColors(vector<int>& nums) {
        int rwb[3];
        for(int i=0; i<nums.size(); i++){
            ++rwb[nums[i]];
        }
        int j = 0;
        int k = 0;
        while(k<3){
            while(rwb[k]>0){
                nums[j++] = k;
                --rwb[k];
            }
            k++;
        }
    }
};