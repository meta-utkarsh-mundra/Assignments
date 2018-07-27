package adtAndCdt;

import java.util.Arrays;

public final class IntSet {
	final int universal_array[] = new int[1000];

	public IntSet() {
		for (int i = 0; i < 1000; i++) {
			universal_array[i] = i+1;
		}
	}
	
	boolean isMember(int x) {
		for(int i = 0 ; i < 1000 ; i++) {
			if(x == universal_array[i]) {
				return true;
			}
		}
		return false;
	}
	
	public int size(int set[]) {
		return set.length;
	}
	
	public boolean isSubSet(int set_s[]) {
		int flag = 0;
		Arrays.sort(set_s);
		for(int i=0 ; i < set_s.length ; i++) {
			for(int j = 0 ; j < universal_array.length ; j++) {
				if(set_s[i] == universal_array[j]) {
					flag = 1;
					break;
				}
			}
			if(flag != 1) {
				return false;
			}
		}
		return true;
	}
	
	public int[] union(int s1[], int s2[]) {
		int count = 0;
		int temp = 0;
		for(int i = 0 ; i< s1.length ; i++) {
			for(int j = 0 ; j < s2.length ;j++) {
				if(s1[i] == s2[j]) {
					count++;
				}
			}
		}
		int union_set[] = new int[s1.length + s2.length - count];
		for(int i = 0 ; i < s1.length ; i++) {
			union_set[temp] = s1[i];
			temp++;
		}
		for(int i = s1.length ; i < s1.length+s2.length ; i++) {
			if(s1[i-s1.length] == s2[i-s1.length]) {
				continue;
			}
			else {
				union_set[temp] = s2[i - s1.length];
				temp++;
			}
		}
		return union_set;
	}

	public int[] getComplement(int a[]) {
		int complement[] = new int[universal_array.length - a.length];
		Arrays.sort(a);
		int count = 0;
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = temp; j < universal_array.length; j++) {
				if (a[i] == universal_array[j]) {
					temp = temp + 1;
					break;
				} else {
					complement[count] = universal_array[j];
					count++;
					temp++;
				}
			}
		}
		return complement;
	}
}
