package annotation;


import java.lang.annotation.Annotation;

@InheritedAnnotation(value = "Applied to SuperClass")
class SuperClass {
    // Superclass implementation
}

class SubClass extends SuperClass {
    // Subclass implementation
}

public class InheritedTest {
    public static void main(String[] args) {
        Class<SubClass> subClass = SubClass.class;
        // Check if the subclass inherits the annotation
        if (subClass.isAnnotationPresent(InheritedAnnotation.class)) {
            Annotation annotation = subClass.getAnnotation(InheritedAnnotation.class);
            InheritedAnnotation inheritedAnnotation = (InheritedAnnotation) annotation;
            System.out.println("SubClass inherits annotation: " + inheritedAnnotation.value());
        } else {
            System.out.println("SubClass does not inherit the annotation.");
        }
    }
}
