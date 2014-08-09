/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * <p/>
 * {description}
 * Copyright (C) 2013 pascalpoizat
 * email: pascal.poizat@lip6.fr
 */

package xsmt.solver.z3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import xsmt.command.*;
import xsmt.expression.Expression;
import xsmt.response.IResponse;
import xsmt.solver.ISolver;

import java.util.ArrayList;


import static org.testng.Assert.*;

public class Z3SolverTest {

    private static final String Z3PATH = "/Users/pascalpoizat/Documents/Applications/Downloads/z3/bin/z3";
    private static final String UNSAT = "unsat";
    private static final String SAT = "sat";
    private ISolver solver;

    @BeforeMethod
    public void setUp() throws Exception {
        solver = new Z3Solver(Z3PATH);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        solver = null;
    }

    @Test
    public void testExecuteUNSAT() throws Exception {
        /**
         * example taken from
         * The SMT-LIB v2 Language and Tools: A Tutorial, by David R. Cok.
         * http://smt-lib.org/
         *
         * p and (not p)
         *
         * (set-logic QF_UF)
         * (declare-fun p () Bool)
         * (assert (and p (not p)))
         * (check-sat)
         */
        solver.start();
        solver.execute(new Set_option("print-warning", "false"));
        solver.execute(new Set_logic("QF_UF"));
        solver.execute(new Declare_fun("p","Bool",new ArrayList<String>()));
        solver.execute(new Assert(new Expression("(and p (not p))")));
        IResponse response = solver.execute(new Check_sat());
        assertEquals(response.toString().endsWith(UNSAT),true);
        solver.execute(new Exit());
    }

    @Test
    public void testExecuteSAT() throws Exception {
        /**
         * example taken from
         * The SMT-LIB v2 Language and Tools: A Tutorial, by David R. Cok.
         * http://smt-lib.org/
         *
         * x + (2 * y) = 20
         * x - y = 2
         *
         * (set-logic QF_LIA)
         * (declare-fun x () Int)
         * (declare-fun y () Int)
         * (assert (= (+ x (* 2 y)) 20))
         * (assert (= (- x y) 2))
         * (check-sat)
         * (get-value (x y))
         */
        solver.start();
        solver.execute(new Set_option("print-warning", "false"));
        solver.execute(new Set_logic("QF_LIA"));
        solver.execute(new Declare_fun("x","Int",new ArrayList<String>()));
        solver.execute(new Declare_fun("y","Int",new ArrayList<String>()));
        solver.execute(new Assert(new Expression("(= (+ x (* 2 y)) 20)")));
        solver.execute(new Assert(new Expression("(= (- x y) 2)")));
        IResponse response = solver.execute(new Check_sat());
        String responseString = response.toString().trim();
        assertEquals(responseString.endsWith(SAT),true);
        ArrayList<String> variables = new ArrayList<String>();
        variables.add("x");
        variables.add("y");
        response = solver.execute(new Get_value(variables));
        assertEquals(response.toString(),"((x 8) (y 6))");
        solver.execute(new Exit());
    }
}