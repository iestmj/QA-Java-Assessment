package com.qa.javaAssessment;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {

        int i = 0;
        int m = 0;
        int count = 0;
        int s1 = 0;
        int s2 = 0;
        int n = 0;
        char a;

        String word = "";

        String lower = input.toLowerCase();
        String bert = new String("bert");
        int len = lower.length();

        for (i = 0; i < input.length(); i++) {

            m = i;
            if (m != len - 1) {														//this is used to make sure it doesn't search past string length so no error occurs
                if (lower.charAt(i) == bert.charAt(0)) {							//lets through letter 'b'

                    if (m + 1 != len - 1) {
                        if ((lower.charAt(m + 1) == bert.charAt(1))) {		 		//lets through letter 'e'

                            if (m + 2 != len - 1) {
                                if (lower.charAt(m + 2) == bert.charAt(2)) { 		//lets through letter 'r'

                                    
                                    if ((lower.charAt(m + 3) == bert.charAt(3))) {	//lets through letter 't'
                                        if (count == 0) {							//if its first bert found then counter changes to 1 and s1 is set to this char index
                                            count++;
                                            s1 = m + 4;
                                        } else if (count > 0) {						//last bert is found and s2 is set to current char index
                                            count++;
                                            s2 = m - 1;
                                        }

                                    }
                                }


                            }
                        }
                    }
                }
            }
        }
        
        if (s2 != 0) {												//if s2=0 then there is only one bert, =return ""
            for (n = s1; n <= s2; n++) {

                a = lower.charAt(n);
                word += a;											//adds char from s1>s2 into word
            }

            int length = word.length();
            char[] reverse = new char[length];
            int b = 0;
            for (b = 0; b < word.length(); b++) {					//puts first letter from word into char reverse and repeats
                reverse[--length] = word.charAt(b);
            }

            
            return new String(reverse);
        }

        else
            return "";
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {

		if ((a - b == b - c) || (a - c == c - b) || (a - b == c - a)) {
			return true;
		}
		else
			return false;

	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
        int mid = input.length()/2;
        int n = a/2;
                                                 

        if (a>1) {
            String start = input.substring(0, input.length() - mid - n - 1);
            String end = input.substring(input.length() - mid + 1);

            input = start + end;
        }
        else if(a==1){
            String start = input.substring(0, input.length() - mid - n - 1);
            String end = input.substring(input.length() - mid);

            input = start + end;
        }



        else if(a==0){
        }
		return input;
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		int count = 0;
		int max = 0;
		
		for(int i=0; i<input.length(); i++){
			
			if(i==0){												
				count++;
				max = count;				
			}
			else{
					if(input.charAt(i)==input.charAt(i-1)){								//If char is same as previous
						count++;														//add 1 to count
					
						if(max<count){													//If max is less than count, set count as new max
							max = count;
						}
					}
						else{																//If char doesn't match then set count to 1
							count = 1;
						}
			}
			
		}
		
		return max;
		
		
		//return -1;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
	    int i = 0;
        int j = 0;
        int m = 0;
        int count = 0;

        String word = new String("Am ");
        String word1 = new String(" am ");
        int len = arg1.length();

        for (i=0; i<arg1.length();i++) {

            m=i;


            if (m != len - 1) {
                if (m==0) {
                    if ((arg1.charAt(0) == word1.charAt(j + 1)) || (arg1.charAt(0) == word.charAt(j))) {          			   //if first letter in string is 'a' it is let through
                        if (m + 1 != len - 1) {
                            if (arg1.charAt(m + 1) == word.charAt(j + 1)) {                                                     //lets through 'm'
                                if (arg1.charAt(m + 2) == word.charAt(j + 2)) {                                                 //lets through ' '
                                    count++;
                                    j = 0;
                                }
                            }
                        }
                    }
                }
                else if (arg1.charAt(i) == word.charAt(j) || (arg1.charAt(i) == word1.charAt(j))) {                              //lets through 'A' and ' '

                    if (m + 1 != len - 1) {
                        if ((arg1.charAt(m + 1) == word.charAt(j + 1)) || (arg1.charAt(m + 1) == word1.charAt(j + 1))) {        //lets through 'm' and 'a'

                            if (m + 2 != len - 1) {
                                if (arg1.charAt(m + 2) == word.charAt(j + 2)) {                                                     //lets through ' '
                                    count++;
                                    j = 0;

                                } else if (arg1.charAt(m + 2) == word1.charAt(j + 2)) {                                               //lets through         'm'
                                    if (m + 3 != len - 1) {
                                        if ((arg1.charAt(m + 3) == word1.charAt(j + 3))) {                                                //lets through         ' '
                                            count++;
                                            j = 0;
                                        }
                                    }
                                        else if (m + 2 == len - 1) {
                                        count++;
                                        j = 0;
                                    }
                                }


                            }
                        }
                    }

                }
            }
        }
        return count;
    }
		
	
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		
		if ((arg1 % 3 == 0 && arg1 % 5 == 0)) {
			return "fizzbuzz";
		}	
		if (arg1 % 3 == 0) {
			return "fizz";
		}
		if (arg1 % 5 == 0) {
			return "buzz";
		}	
			return null;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
        int i = 0;
        int a = 0;
        int b = 0;
        int sum = 0;
        int max = 0;
        int temp = 0;

        String[] values = arg1.split(" ");
        int len = values.length;

        for (i=0; i<len; i++){
            a = Integer.parseInt(values[i]);

            while (a > 0) {
                b  = a % 10;

                sum += b;

                a /= 10;
            }

            if (a == 0) {

                if (sum > temp) {
                    max = sum;
                }
            }
            temp = max;
            sum = 0;
        }
		return max;
	
	}
	
}
