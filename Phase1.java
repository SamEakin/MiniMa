package edu.uiowa.cs;

import java.util.LinkedList;
import java.util.List;

public class Phase1 {

    /* Translates the MAL instruction to 1-3 TAL instructions
     * and returns the TAL instructions in a list
     *
     * mals: input program as a list of Instruction objects
     *
     * returns a list of TAL instructions (should be same size or longer than input list)
     */
    public static List<Instruction> mal_to_tal(List<Instruction> mals) {
		List<Instruction> tals = new List<Instruction> ();

		//1. iterate through the mals
		for (Instruction mal: mals) {
			//2. check the op code for the MAL.
			//		if it is really a MAL then do the proper conversion.
			if (mal.instruction_id == "blt") { // blt r1, r2, goHere
				tals.append(CreateSlt(1, mal.rs, mal.rt);
				tals.append(CreateBeq(1, 0, mal.branch_label);
			}
			else if (mal.instruction_id == "bge") { //bge rs, rt, goHere
				tals.append(CreateSlt(1, mal.rs, mal.rt);
				tals.append(CreateBne(1, 0, mal.branch_label);
			}	
			else if (mal.instruction_id == "addiu" && mal.immediate > 65535) {
				tals.append(CreateLui(1, mal.immediate); // only going to use the upper 16-bits
				tals.append(CreateOri(1, 1, mal.immediate); // only going to use the upper 16-bits
				tals.append(CreateAddu(mal.rt, mal.rs, 1);
			} 
			else if (mal.instruction_id == "ori" && mal.immediate > 65535) {
				tals.append(CreateLui(1, mal.immediate); // only going to use the upper 16-bits
				tals.append(CreateOri(1, 1, mal.immediate); // only going to use the upper 16-bits
				tals.append(CreateAddu(mal.rt, mal.rs, 1);
			}
			else {
				tals.append(mal.copy());
			}
		}
        return tals;
    }
}
