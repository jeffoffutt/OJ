/*
 * This code was generated by ojc.
 */
/*
 * RichSyntaxClass.java
 *
 * comments here.
 *
 * @author   Michiaki Tatsubori
 * @version  %VERSION% %DATE%
 * @see      java.lang.Object
 *
 * COPYRIGHT 1999 by Michiaki Tatsubori, ALL RIGHTS RESERVED.
 */
package examples.syntax;


import java.lang.Object;
import openjava.mop.*;
import openjava.ptree.*;
import openjava.syntax.*;


public class RichSyntaxClass extends OJClass
{

    public void translateDefinition()
    {
        String[] str = new String[]{ "hates", "loves", "keeps", "forwards", "before", "after", "chooses", "adapts" };
        for (int i = 0; i < str.length; ++i) {
            ParseTree suffix;
            suffix = this.getSuffix( str[i] );
            if (suffix != null) {
                System.out.println( this.toString() + " involves a suffix " + " ( " + str[i] + " ):" );
                System.out.println( "\t" + suffix );
            }
            OJMethod[] methods = getDeclaredMethods();
            for (int j = 0; j < methods.length; ++j) {
                suffix = methods[j].getSuffix( str[i] );
                if (suffix != null) {
                    System.out.println( methods[j].toString() + " involves a suffix " + " ( " + str[i] + " ):" );
                    System.out.println( "\t" + suffix );
                }
            }
        }
    }

    public static boolean isRegisteredKeyword( String keyword )
    {
        if (keyword.equals( "hates" )) {
            return true;
        }
        if (keyword.equals( "loves" )) {
            return true;
        }
        if (keyword.equals( "keeps" )) {
            return true;
        }
        if (keyword.equals( "forwards" )) {
            return true;
        }
        if (keyword.equals( "before" )) {
            return true;
        }
        if (keyword.equals( "after" )) {
            return true;
        }
        if (keyword.equals( "chooses" )) {
            return true;
        }
        if (keyword.equals( "adapts" )) {
            return true;
        }
        return OJClass.isRegisteredKeyword( keyword );
    }

    public static SyntaxRule getDeclSuffixRule( String keyword )
    {
        if (keyword.equals( "hates" )) {
            return new NameRule();
        }
        if (keyword.equals( "loves" )) {
            return new TypeNameRule();
        }
        if (keyword.equals( "keeps" )) {
            return new ExpressionRule();
        }
        if (keyword.equals( "forwards" )) {
            return new IterationRule( new TypeNameRule(), false );
        }
        if (keyword.equals( "before" ) || keyword.equals( "after" )) {
            return new BlockRule();
        }
        if (keyword.equals( "chooses" ) || keyword.equals( "after" )) {
            return new SelectionRule( new TypeNameRule(), new BlockRule() );
        }
        if (keyword.equals( "adapts" ) || keyword.equals( "after" )) {
            return new CompositeRule( new NameRule(), new PrepPhraseRule( "in", new NameRule() ), new PrepPhraseRule( "to", new NameRule() ) );
        }
        return OJClass.getDeclSuffixRule( keyword );
    }

    public static SyntaxRule getTypeSuffixRule( String keyword )
    {
        return OJClass.getTypeSuffixRule( keyword );
    }

    public static boolean isRegisteredModifier( String keyword )
    {
        if (keyword.equals( "remote" )) {
            return true;
        }
        if (keyword.equals( "crazy" )) {
            return true;
        }
        return false;
    }

    public RichSyntaxClass( openjava.mop.Environment oj_param0, openjava.mop.OJClass oj_param1, openjava.ptree.ClassDeclaration oj_param2 )
    {
        super( oj_param0, oj_param1, oj_param2 );
    }

    public RichSyntaxClass( java.lang.Class oj_param0, openjava.mop.MetaInfo oj_param1 )
    {
        super( oj_param0, oj_param1 );
    }

}
