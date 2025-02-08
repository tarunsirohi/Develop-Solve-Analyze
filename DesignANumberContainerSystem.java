import java.util.*;

class NumberContainers {
    private Map<Integer, Integer> indexNumber; // Maps index to number
    private Map<Integer, TreeSet<Integer>> numberIndices; // Maps number to sorted set of indices

    public NumberContainers() {
        indexNumber = new HashMap<>();
        numberIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        // If the index is already in use, remove the old number
        if (indexNumber.containsKey(index)) {
            int oldNumber = indexNumber.get(index);
            numberIndices.get(oldNumber).remove(index);
            if (numberIndices.get(oldNumber).isEmpty()) {
                numberIndices.remove(oldNumber); // Remove if no indices left for the old number
            }
        }

        // Insert the new number
        indexNumber.put(index, number);
        numberIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        if (!numberIndices.containsKey(number)) {
            return -1; // Number not found
        }
        return numberIndices.get(number).first(); // Return the smallest index
    }
}
