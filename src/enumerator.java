/**
 * Created by david on 5/4/16.
 */
abstract interface enumerator {

    public boolean hasMoreElements(); //* returns true if there are more elements left, false otherwise */

    public Object nextElement(); //* returns next element */

}
