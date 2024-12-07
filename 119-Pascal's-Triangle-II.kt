class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        val numbers = MutableList(rowIndex + 1) { 1 }
        val start = 1
        var end = rowIndex - 1
        
        while(start <= end) {
            for(current in start .. end) {
                numbers[current] += numbers[current - 1]
            }
            end--
        }
        return numbers
    }
}
