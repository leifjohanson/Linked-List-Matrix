public class MatrixColumn {
    private ValueNode first;
    private MatrixColumn next;

    public MatrixColumn() {}

    public ValueNode getFirst() {
        return first;
    }

    public MatrixColumn getNext() {
        return next;
    }

    public void setNext(MatrixColumn next) {
        this.next = next;
    }

    public void insert(ValueNode value) {
        // case 1
        if(first == null) {
            first = value;
        }
        // case 2
        else if(value.getRow() < first.getRow()) {
            ValueNode temp = first;
            first = value;
            first.setNextRow(temp);
        }
        // case 3
        else if(value.getRow() > first.getRow()) {
            ValueNode currentNode = first;
            while(currentNode.getNextRow() != null) {
                int compare1 = currentNode.getRow();
                int compare2 = currentNode.getNextRow().getRow();
                if(compare1 < value.getRow() && compare2 > value.getRow()) {
                    ValueNode temp = currentNode.getNextRow();
                    currentNode.setNextRow(value);
                    value.setNextRow(temp);
                }
                currentNode = currentNode.getNextRow();
            }
        }
    }

    public int get(int position) {
        ValueNode current = first;
        for(int i = 1; i <= position; i++) {
            try {
                if (current.getRow() == position) {
                    return current.getValue();
                }
            }
            catch(Exception e) {
                return 0;
            }
            if(current.getNextRow() != null) {
                current = current.getNextRow();
            }
        }
        return 0;
    }
}
