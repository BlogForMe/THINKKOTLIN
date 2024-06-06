package annotation.doc;


@ClassPreamble(
    author = "John Doe",
    date = "06/06/2024",
    currentRevision = 2,
    lastModified = "06/06/2024",
    lastModifiedBy = "Jane Doe",
    reviewers = {"Alice", "Bob"}
)
public class MyClass {
    // Class implementation
    void print(){ // the function will not generate doc
        System.out.println("print");
    }
}
