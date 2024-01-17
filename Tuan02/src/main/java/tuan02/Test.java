package tuan02;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		ParseResult<CompilationUnit> parseResult = new JavaParser().parse(new File("src\\main\\java\\tuan02\\Account.java"));
		Optional<CompilationUnit> result = parseResult.getResult();
		if(result.isPresent()) {
			CompilationUnit cu = result.get();
			for(FieldDeclaration f : getFields(cu))
				System.out.println(f);
			System.out.println("==========");
			for(MethodDeclaration m : getMethods(cu))
				System.out.println(m.getName());
		}
//		Account account = new Account();
//		Class<? extends Account> class1 = account.getClass();
//		String name = class1.getName();
//		System.out.println("Name: "+ name);
		
	}
	
	public static List<FieldDeclaration> getFields(CompilationUnit cu) {
		return cu.findAll(FieldDeclaration.class);
	}
	
	public static List<MethodDeclaration> getMethods(CompilationUnit cu) {
		return cu.findAll(MethodDeclaration.class);
	}
}
