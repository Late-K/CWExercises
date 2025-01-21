// Edit this file with your working implementation

// Mutable string
public class DynString {
    private char[] data;

    // Constructor for given size
    public DynString(int len) {
        resizeData(len);
    }

    // Constructor copying values from char array
	public DynString(char[] src){
		this(src.length);
		for(int i=0; i<size(); ++i){
			data[i] = src[i];
		}
	}
    
    // Get current size
    public int size() {
        return data.length;
    }

    // Resize internal array, zeroing values
    private void resizeData(int n) {
        data = new char[n];
    }

 // default constructor
	public DynString() {
		resizeData(0);
	}
	
    // check if empty
    public boolean empty() {
        return size() == 0;
    }
    
    // constructor for a string
    public DynString(String string) {
        resizeData(string.length());
        for (int i = 0; i < string.length(); i++) {
            data[i] = string.charAt(i);
        }
    }

    // in a string get the character at i
    public char get(int i) {
        return data[i];
    }

    // in a string set a character at i
    public void set(int i, char c) {
        data[i] = c;
    }
    
    // constructor for amount of character
    public DynString(int i, char c) {
        resizeData(i);
        for (int j = 0; j < i; j++) {
            data[j] = c;
        }
    }
    
    // copy an array from data to newData starting from start
    private void copyArray(char[] data, char[] newData, int start) {
        for (int i = 0; i < Math.min(data.length - start, newData.length); i++) {
            newData[i] = data[start + i];
        }
    }
    
    // resize an array preserving the original values
    public void resize(int newSize) {
    	char[] newData = new char[newSize];
        copyArray(data, newData, 0);
        data = newData;
    }

    // clear by resizing to zero
    public void clear() {
        resizeData(0);
    }

    // checks if two arrays are the same
    private boolean equalsFunc(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false; 
            }
        }
        return true;
    }

    public boolean equals(String string) {
        return equalsFunc(data, string.toCharArray());
    }

    public boolean equals(char[] c) {
        return equalsFunc(data, c);
    }

    public boolean equals(DynString d) {
            return equalsFunc(data, d.data);
    }

    // new array from point i to j of an old array
    public DynString substr(int i, int j) {
        char[] newData = new char[j - i];
        copyArray(data, newData, i);
        return new DynString(newData);
    }

    // new array from i onwards of an old array
    public DynString substr(int i) {
        return substr(i, data.length);
    }
    
    // merge strings together
	public DynString concat(char[] c) {
        char[] newData = new char[data.length + c.length];
        copyArray(data, newData, 0);
        for (int i = 0; i < c.length; i++) {
            newData[data.length + i] = c[i];
        }
        return new DynString(newData);
    }
	
	public DynString concat(String string) {
        return concat(string.toCharArray());
	}

	public DynString concat(DynString d) {
        return concat(d.data);
    }

}