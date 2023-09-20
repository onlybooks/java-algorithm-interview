package ch17

class P68_3 {
    fun isAnagram(s: String, t: String): Boolean {
        return String(s.toCharArray().apply { sort() }) ==
                String(t.toCharArray().apply { sort() })
    }
}