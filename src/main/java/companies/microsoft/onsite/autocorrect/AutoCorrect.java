package companies.microsoft.onsite.autocorrect;

/**
 * What is the work of autocorrect system
 * An autocorrect system changes a mispelled word into correct spelling
 *
 * Steps for implementing an autocorrecy system
 *
 * 1) Identify the mispelled word
 * 2) Find strings that are n edit distance away from the mispelled word
 * 3) Filter suggested candidates to retain only the ones found in the vocabulary
 * 4) Order filtered candidates based on word probabilities
 * 5)
 *
 *
 * Identifying a mispelled word
 * A word is mispelled if it is not found on the vocabulary of the corpus
 * of text the autocorrect system is working with
 *
 * Finding string that are n edit distances away
 * Editing is an operation perforemd on a string to change it into another string
 * AAn edit distance is a count of the number of operations on a string to change it
 * into another string. An edit distance is acount of the number of operations
 * performed on a word to edit it.
 *
 * Type of edit operations
 * 1) INSERT (add a letter) Example "to" => "top","two"
 * 2) DELETE (remove a letter) Example "hat" =? "at","ha","ht"
 * 3) SWAP ( swap 2 adjacent letters) Example  "eta" => "tea", "eat"
 * 4) REPLACE ( changes one letter to another). Example "jaw" => "jar", "paw"
 */


public class AutoCorrect {
}
