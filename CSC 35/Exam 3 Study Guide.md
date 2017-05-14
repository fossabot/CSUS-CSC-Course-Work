# Exam 3 Study Guide
> Binary & Hex Numbers

> Notation (why important)

> ASCII

> Integers

> Floating point numbers

> Components of the processor

> Privileged mode

> Types of operands

> Types of opcodes

> x86 Registers

> Compilers

> Assemblers

> Linkers

> Sign-magnitude

> One's complement

> Two's complement

> Multiplication

> Division

> Sign Extension

> Concept of flags

> How jump statements work

> How to implement If

> Statements, While, For, Switch

> What is memory (address, etc.…)

> Endianness
 
> Addressing modes

> How arrays work

> The stack

> Passing parameters using registers

> Stack frames

> How they work on the x86

> von Neumann architecture

> Operands

> CISC vs. RISC

> Instruction Encoding

> Multiprogrammed

> Timeslice and context switch

> Kernal

> Vector Tables

> Interrupts

> 5 stages of execution

1. **Fetch** an instruction from memory.
    -  First, the processor fetches the instruction from the memory.
    - The result is stored in the Instruction Register.
    - known as Instruction Fetch (IF).
2. **Decode** it to determine what it is.
    - Second, the instruction is decoded to determine what it is and its operands.
    - Signals are sent to the execution unit as input.
    - Formally known as Instruction Decode (ID).
3. **Read** the inputs from registers / memory.
    - The Execution Unit then reads the values of the instruction.
    - These can be in located in the instruction itself (immediate), register file, and from memory
    - Formally known as Memory Access (Mem).
4. **Execute** for computations for instruction.
    - Decoded instruction and input values are passed to the ALU.
    - Depending on the complexity of the instruction, some computations require multiple clock cycles.
        - e.g. multiplication is requiresmore cycles and an add.
    - Formally: Execute (EX)
5. **Write** the result into the registers / memory.
    - Finally, the result is written back into the register / memory.
    - Processor also updates flags and other state information such as the Program Counter.
    - Formally known as Write Back (WB).

> Pipelining

- Pipelining is an technique where multiple instructions are executed at the same time.
    - Laundry example...
- This greatly improves the speed (and efficiency) of a system.

> Data hazards

> Jump hazards
