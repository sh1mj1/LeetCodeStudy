class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        for(row in 0 until numRows) {
            val currentRow = mutableListOf<Int>()
            for(col in 0 .. row) {
                if (row == 0 || col == 0 || col == row) currentRow.add(1) 
                else (result[row-1][col-1] + result[row-1][col]).let(currentRow::add)
            }
            result.add(currentRow)
        }
        return result
    }
}
