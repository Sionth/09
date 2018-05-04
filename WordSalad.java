/* File: WordSalad.java - April 2018 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Skeleton implementation of the WordSalad class.
 *
 * @author Quinn Thorsnes, Kelson Sadlier, Yohan de Rose
 */
public class WordSalad implements Iterable<String> {

    /**
     * Allows WordSalad to know what WordNode comes first in the LinkedList.
     */
    private WordNode first;
    /**
     * Allows WordSalad to know what WordNode comes last in the LinkedList.
     */
    private WordNode last;

    /**
     * Constructs an empty WordSalad object.
     */
    public WordSalad() {
        this.first = null;
        this.last = null;
    }

    /**
     * Constructs WordSalad object from String List object.
     * @param words a list of strings
     */
    public WordSalad(java.util.List<String> words) {
        for (String word : words) {
            addLast(word);
        }
    }

    /**
     * @param word
     */
    public void add(String word) {
        if (this.first == null) {
            this.first = new WordNode(word, null);
            this.last = this.first;
            return;
        }
        WordNode newFirst = new WordNode(word, this.first);
        this.first = newFirst;
    }

    /**
     * @param word
     */
    public void addLast(String word) {
        if (this.first == null) {
            add(word);
            return;
        }
        WordNode newLast = new WordNode(word, null);
        this.last.next = newLast;
        this.last = newLast;
    }

    /**
     *
     */
    private class WordNode {
        private String word;
        private WordNode next;

        private WordNode(String word, WordNode next) {
            this.word = word;
            this.next = next;
        }

    }
<<<<<<< HEAD
    /**
     * Implementation of Iterator class used to iterate across WordNodes.
     *
     * @return java.util.Iterator<String> String iterator object.
=======

    /**
     * @return
>>>>>>> cff53c457e9f26119de69c78bd4148a5697fc3e1
     */
    public java.util.Iterator<String> iterator() {
        return new java.util.Iterator<String>() {
            /**
             * Sets the current WordNode to the first node.
             */
            private WordNode current = first;
            /**
             * Checks if the current WordNode is empty.
             *
             * @return Returns true if the current node is not null or returns
             * false if the current node is null.
             */
            public boolean hasNext() {
                return current != null;
            }
            /**
             * Returns the word held in the current node, then changes the
             * current node to point to the next node.
             *
             * @return result The word in the current node.
             */
            public String next() {
                String result = current.word;
                current = current.next;
                return result;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
<<<<<<< HEAD
    /**
     * Shows a string representation of word blocks in WordSalad object.
     *
     * @return result String representation of block(s) of words.
=======

    /**
     * @return
>>>>>>> cff53c457e9f26119de69c78bd4148a5697fc3e1
     */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        WordNode node = first;
        while (node != null) {
            result.append(node.word);
            result.append(node.next == null ? "" : ", ");
            node = node.next;
        }
        return result.toString() + "]";
    }


    // Method stubs to be completed for the assignment.
    // See the assignment description for specification of their behaviour.

<<<<<<< HEAD
   /**
    * Puts the first word in first block, 2nd in 2nd block, kth word in kth block,
    * wrap around blocks
    * like when dealing out cards
    *
    * @param k The number of blocks to distribute into
    * @return an array of distributed WordSalads
    */
=======
    /**
     * Puts the first word in first block, 2nd in 2nd block, kth word in kth block,
     * wrap around blocks
     * like when dealing out cards
     *
     * @param k The number of blocks to distribute into
     * @return an array of WordSalads
     */
>>>>>>> cff53c457e9f26119de69c78bd4148a5697fc3e1
    public WordSalad[] distribute(int k) {
        // make use of modulo operator to determine which group to put a word in
        // remember that WordSalads are linked lists of Strings with add() and addLast() methods
        WordSalad[] distribution = new WordSalad[k];
        int wordCount = 0;
        int currIndex;
        for (int i = 0; i < k; i++) {
            distribution[i] = new WordSalad();
        }
        for (String word : this) {
            currIndex = wordCount % k;
            distribution[currIndex].addLast(word);
            wordCount++;
        }
        return distribution;
    }
<<<<<<< HEAD
    /**
     * Chops a block of words into k equal, or nearly equal, blocks of words.
     *
     * @param k the number of blocks to chop into.
     * @return result chopped array of k WordSalads.
=======

    /**
     * This method divides the count of words in this into almost equal blocks and  populates an ArrayList with these values.
     * This is then used as the lengths for corresponding WordSalad objects in another array.
     * From the start of the original WordSalad object we fill each WordSalad block until its corresponding length is met, and continue until the whole array is full.
     * @param k used to divide original length into almost equal lengths
     * @return an array of WordSalad objects chopped into k pieces
>>>>>>> cff53c457e9f26119de69c78bd4148a5697fc3e1
     */
    public WordSalad[] chop(int k) {
        //establish lengths of each WordSalad item
        ArrayList<Integer> lengths = new ArrayList<>();
        Iterator<String> pointer = this.iterator();
        int count = 0;

        while (pointer.hasNext()) {
            pointer.next();             //remember to move iterator along
            count++;
        }
        int x = count / k;
        int r = count % k;

        for (int i = 0; i < k - r; i++) {
            lengths.add(x);       //add x (k-r) times
        }                     //while sum != words: add (count%sum)/r, r--

        int sum = 0;
        for (int i : lengths) {
            sum += i;
        }

        while (sum != count) {
            lengths.add(0, (count % sum) / r);
            r--; //might be r/2
            sum = 0;
            for (int i : lengths) {
                sum += i;
            }
        }

        //construct WordSalad array with reference to lengths
        WordSalad[] result = new WordSalad[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = new WordSalad();
        }
<<<<<<< HEAD

=======
>>>>>>> 71315c7ffad073e840dc447125dbddcbd21385e5

        pointer = this.iterator();
        for (int i = 0; i < lengths.size(); i++) {
            int saladSize = 0;
            while (saladSize < lengths.get(i)) {
                result[i].addLast(pointer.next());
                saladSize++;
            }
        }
        return result;
    }
//   Other Chop Method.
//   public WordSalad[] chop(int k) {
//   WordSalad[] choppedSalad = new WordSalad[k];
//   Iterator<String> point = this.iterator();
//   int length = 0;
//
//   //Instantiate k new word salad objects
//   for(int i = 0; i < k; i++){
//     choppedSalad[i] = new WordSalad();
//   }
//   //Find length of input Wordsalad Object
//   while(point.hasNext()){
//     point.next();
//     length++;
//   }
//   //If length can be split evenly across k word salad objects.
//   if(length % k == 0){
//
//     int blockLength = (length/k);
//     WordNode currentNode = this.first;
//
//     for(int i = 0; i < k; i++){
//       for(int j = 0; j < blockLength; j++){
//         choppedSalad[i].addLast(currentNode.word);
//         currentNode = currentNode.next;
//       }
//     }
//     return choppedSalad;
//   //If length cannot be evenly split across k wordsalad objects.
//   }else{
//     int blockLengthStart = (length/k) + 1;
//     int blockLengthStartNum = (length%k);
//     WordNode currentNode = this.first;
//
//     for(int choppedSaladIndex = 0; choppedSaladIndex < blockLengthStartNum; choppedSaladIndex++){
//       for(int j = 0; j < blockLengthStart; j++){
//         choppedSalad[choppedSaladIndex].addLast(currentNode.word);
//         currentNode = currentNode.next;
//         }
//     }
//
//     int blockLengthRest = (length/k);
//     int blockLengthRestNum = k - blockLengthStartNum;
//
//       for(int h = 0; h < blockLengthRestNum; h++){
//         for(int j = 0; j < blockLengthRest; j++){
//           choppedSalad[choppedSaladIndex].addLast(currentNode.word);
//           currentNode = currentNode.next;
//       }
//       choppedSaladIndex++;
//     }
//     return choppedSalad;
//   }
//
// }

    /**
     * This method distributes the WordSalad object and keeps the first element of this result, merging the remaining elements so the words are ordered.
     * Then the distribute is called on these remaining, first element is kept, remainder ordered and so on until the original object is empty.
     * @param k count that each distribute call is passed
     * @return returns an array of WordSalad objects that are split
     */
    public WordSalad[] split(int k) {
        WordSalad[] currPass;
        WordSalad[] lastPass;
        WordSalad[] finalPass = new WordSalad[0];
        WordSalad saladLeft = this;
        int finalLength = 0;
        boolean splitting = true;
        while (splitting) {
            lastPass = finalPass;
            currPass = saladLeft.distribute(k);
            saladLeft = merge(Arrays.copyOfRange(currPass, 1, currPass.length));
            if (saladLeft.first == null) {
                splitting = false;
            }

            finalPass = new WordSalad[lastPass.length + 1];
            for (int i = 0; i < lastPass.length; i++) {
                finalPass[i] = lastPass[i];
            }

            finalPass[lastPass.length] = currPass[0];
        }
        return finalPass;
    }
<<<<<<< HEAD
    /**
      * Merges blocks of words into a single block of words.
      *
      * Takes the n'th word from each block until all blocks are empty.
      * If a block is emptied it is then skipped in subsequent rounds.
      *
      * Opposite of distribute, so merging a distributed text will result in
      * the same original text.
      *
      * @param blocks An array of WordSalad blocks of words to be merged.
      * @return merged WordSalad object of merged blocks of words.
      */
=======

    /**
     * @param blocks
     * @return
     */
>>>>>>> cff53c457e9f26119de69c78bd4148a5697fc3e1
    public static WordSalad merge(WordSalad[] blocks) {
        // The opposite of distribute
        WordSalad merged = new WordSalad();
        WordNode[] mergeNodes = new WordNode[blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            mergeNodes[i] = blocks[i].first;
        }
        boolean merging = true;
        while (merging) {
            for (int i = 0; i < mergeNodes.length; i++) {
                if (mergeNodes[i] == null) {
                    merging = false;
                } else {
                    merged.addLast(mergeNodes[i].word);
                    mergeNodes[i] = mergeNodes[i].next;
                }
            }
        }
        return merged;
    }
<<<<<<< HEAD
    /**
     * Joins blocks of words into a single block of words.
     *
     * Opposite of chop, so joining a chopped text results in the same original
     * text.
     *
     * @param blocks Array of WordSalad blocks to be joined.
     * @return joined Single WordSalad object containing joined blocks of words.
=======

    /**
     * @param blocks
     * @return
>>>>>>> cff53c457e9f26119de69c78bd4148a5697fc3e1
     */
    public static WordSalad join(WordSalad[] blocks) {
        // The opposite of Chop
        WordSalad joined = new WordSalad();
        for (WordSalad salad : blocks) {
            for (String word : salad) {
                joined.addLast(word);
            }
        }

        return joined;
    }

    /**
     * @param blocks
     * @param k
     * @return
     */
    public static WordSalad recombine(WordSalad[] blocks, int k) {
        // opposite of split... so... do split in reverse?
        WordSalad[] curToMerge = new WordSalad[1];
        WordSalad[] lastDist;
        WordSalad recombination = new WordSalad();
        int dists = 0;
        boolean recombining = true;
        while (recombining) {
            if (recombination.first != null) {
                lastDist = recombination.distribute(k - 1);
                curToMerge = new WordSalad[lastDist.length + 1];
                for (int i = 0; i < (curToMerge.length - 1); i++) {
                    curToMerge[i + 1] = lastDist[i];
                }

                if (lastDist.length == 2) {
                    curToMerge[2] = lastDist[1];
                }
            }
            dists++;
            if (dists >= blocks.length) {
                recombining = false;
            }
            curToMerge[0] = blocks[blocks.length - dists];
            recombination = merge(curToMerge);
        }


        return recombination;
    }

}
