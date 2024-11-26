class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        if(n == 0) return
        var p = m+n-1
        var p1 = m-1
        var p2 = n-1
        
        while(p >=0) {
            if(p2 < 0) break
            if( p1 < 0 || nums2[p2] > nums1[p1]) {
                nums1[p--] = nums2[p2--]
            }else {
                nums1[p--] = nums1[p1--]
            }
        }    
    }

    fun simpleMerge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        nums2.forEachIndexed { index, num -> 
            nums1[m+index] = num
        }
        nums1.sort()
    }

}
