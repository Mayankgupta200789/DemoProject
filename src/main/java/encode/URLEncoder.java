package encode;

import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;

/**
 * @Author Mayank Gupta
 * @Date 1/10/18
 */
public class URLEncoder {


	private static BitSet dontNeedEncoding;

	static {

        /* The list of characters that are not encoded has been
         * determined as follows:
         *
         * RFC 2396 states:
         * -----
         * Data characters that are allowed in a URI but do not have a
         * reserved purpose are called unreserved.  These include upper
         * and lower case letters, decimal digits, and a limited set of
         * punctuation marks and symbols.
         *
         * unreserved  = alphanum | mark
         *
         * mark        = "-" | "_" | "." | "!" | "~" | "*" | "'" | "(" | ")"
         *
         * Unreserved characters can be escaped without changing the
         * semantics of the URI, but this should not be done unless the
         * URI is being used in a context that does not allow the
         * unescaped character to appear.
         * -----
         *
         * It appears that both Netscape and Internet Explorer escape
         * all special characters from this list with the exception
         * of "-", "_", ".", "*". While it is not clear why they are
         * escaping the other characters, perhaps it is safest to
         * assume that there might be contexts in which the others
         * are unsafe if not escaped. Therefore, we will use the same
         * list. It is also noteworthy that this is consistent with
         * O'Reilly's "HTML: The Definitive Guide" (page 164).
         *
         * As a last note, Intenet Explorer does not encode the "@"
         * character which is clearly not unreserved according to the
         * RFC. We are being consistent with the RFC in this matter,
         * as is Netscape.
         *
         */

		dontNeedEncoding = new BitSet(256);
		int i;
		for (i = 'a'; i <= 'z'; i++) {
			dontNeedEncoding.set(i);
		}
		for (i = 'A'; i <= 'Z'; i++) {
			dontNeedEncoding.set(i);
		}
		for (i = '0'; i <= '9'; i++) {
			dontNeedEncoding.set(i);
		}
		dontNeedEncoding.set(' '); /* encoding a space to a + is done
                                    * in the encode() method */
		dontNeedEncoding.set('-');
		dontNeedEncoding.set('_');
		dontNeedEncoding.set('.');
		dontNeedEncoding.set('*');
		dontNeedEncoding.set('=');
		dontNeedEncoding.set('&');
	}

	static final int caseDiff = ('a' - 'A');


	public static void main(String[] args) throws UnsupportedEncodingException {


		String encode = new URLEncoder().encode("loanInfo=&applicant_type=individual&amount_req=&down_pay=0.00&loan_term=72&trade_in=no&additionalInfo=&customer:comments=I need some help getting a car loan. I had previously purchased a 2012 Accent from this dealership in 2016. I totaled the vehicle 12/29/17. I still owe $1540 on the loan - I did NOT have gap insurance. The car was financed through Citadel. They approved me for a new loan - up to $20K/66months/15.29% on a used 2012 -2015 vehicle. That is what certificate states. However, the catch from them is I have to pay the $1540 from the old loan, BEFORE they will grant the new loan. I do not have that money right now.&&I was working with Jeff D'ambrosio Chevrolet in Oxford, PA on a Trax. They tried to roll the old loan into the new, but they wouldn't approve that amount.&&They stated they could get me approved on a used Chrysler 200, of which I really do not like.&&I would prefer a large car than the accent, I now have a 1 year old, and the car seat barely fit into the accent. Also something good on gas, as my job requires alot of distance driving.&&I'm not sure if you could help me. I worked with Matt in sales, in&contactInfo=&contact:name:first=Juliana&contact:name:last=Casella&preferred_contact=email&contact:email=julianamcasella@gmail.com&contact:phone:phone:day=6104700693&contact:phone:phone:evening=&contact:phone:cellphone=&contact:phone:fax=&contact:address:home:street=115 E 2nd Street a3&contact:address:home:city=Quarryville&contact:address:home:regioncode=PA&contact:address:home:postalcode=17566&applicantInfo=&dob=1993/06/11&residence_type=rent&residence_monthly_pay=600.00&residence_years=1&residence_months=1&employmentInfo=&employer=Investment Real Estate Management&occupation=Relief Manager&monthly_income=2200&job_years=1&job_months=7&emp_phone=7177790804&contact:address:work:street=&contact:address:work:city=York&contact:address:work:region=PA&contact:address:work:zip=17404&otherIncome=&other_source=&other_monthly=&default_section=&hp:contact:cmpny:phone=&cellName=request_financing&pageName=FinancePreQualForm&outputType=json&widgetType=emailforms&widgetName=requestFinancing_widget&productId=46.114.00&advertisingSource=&web_id=hyun-lancaster&widgetContext=null&lead_type=Finance&consentInfo=&tcpa:optin=Y&jointFieldsContainer=&contactInfo_jointApplicant=&joint_first_name=&joint_last_name=&joint_preferred_contact=email&joint_email=&joint_day_phone=&joint_home_phone=&joint_cell_phone=&joint_fax=&joint_address=&joint_city=&joint_state=PA&joint_zip=&applicantInfo_jointApplicant=&joint_dob=&joint_residence_type=own&joint_residence_monthly_pay=&joint_residence_years=&joint_residence_months=&employmentInfo_jointApplicant=&joint_employer=&joint_occupation=&joint_monthly_income=&joint_job_years=&joint_job_months=&joint_emp_phone=&joint_emp_address=&joint_emp_city=&joint_emp_state=PA&joint_emp_zip=&otherIncome_jointApplicant=&joint_other_source=&joint_other_monthly=", "UTF-8");
	}


	public static String encode(String s , String enc) throws UnsupportedEncodingException {
		boolean needToChange = false;
		StringBuffer out = new StringBuffer(s.length());
		Charset charset;
		CharArrayWriter charArrayWriter = new CharArrayWriter();

		if (enc == null)
			throw new NullPointerException("charsetName");

		try {
			charset = Charset.forName(enc);
		} catch (IllegalCharsetNameException e) {
			throw new UnsupportedEncodingException(enc);
		} catch (UnsupportedCharsetException e) {
			throw new UnsupportedEncodingException(enc);
		}

		for (int i = 0; i < s.length();) {
			int c = (int) s.charAt(i);
			//System.out.println("Examining character: " + c);
			if (dontNeedEncoding.get(c)) {
				if (c == ' ') {
					c = '+';
					needToChange = true;
				}
				//System.out.println("Storing: " + c);
				out.append((char)c);
				i++;
			} else {
				// convert to external encoding before hex conversion
				do {
					charArrayWriter.write(c);
                    /*
                     * If this character represents the start of a Unicode
                     * surrogate pair, then pass in two characters. It's not
                     * clear what should be done if a bytes reserved in the
                     * surrogate pairs range occurs outside of a legal
                     * surrogate pair. For now, just treat it as if it were
                     * any other character.
                     */
					if (c >= 0xD800 && c <= 0xDBFF) {
                        /*
                          System.out.println(Integer.toHexString(c)
                          + " is high surrogate");
                        */
						if ( (i+1) < s.length()) {
							int d = (int) s.charAt(i+1);
                            /*
                              System.out.println("\tExamining "
                              + Integer.toHexString(d));
                            */
							if (d >= 0xDC00 && d <= 0xDFFF) {
                                /*
                                  System.out.println("\t"
                                  + Integer.toHexString(d)
                                  + " is low surrogate");
                                */
								charArrayWriter.write(d);
								i++;
							}
						}
					}
					i++;
				} while (i < s.length() && !dontNeedEncoding.get((c = (int) s.charAt(i))));

				charArrayWriter.flush();
				String str = new String(charArrayWriter.toCharArray());
				byte[] ba = str.getBytes(charset);
				for (int j = 0; j < ba.length; j++) {
					out.append('%');
					char ch = Character.forDigit((ba[j] >> 4) & 0xF, 16);
					// converting to use uppercase letter as part of
					// the hex value if ch is a letter.
					if (Character.isLetter(ch)) {
						ch -= caseDiff;
					}
					out.append(ch);
					ch = Character.forDigit(ba[j] & 0xF, 16);
					if (Character.isLetter(ch)) {
						ch -= caseDiff;
					}
					out.append(ch);
				}
				charArrayWriter.reset();
				needToChange = true;
			}
		}

		return (needToChange? out.toString() : s);
	}
}
