-- | author  : Joseph Matthew Ching
-- | run     : runhaskell probA.hs int
-- | solve the problem using divide and conquer. Start with creating 4 small
--   patterns and from there, use them to build the larger letter patterns.

import System.Environment (getArgs)
import Util (joinList)

---- | read an int from first argument
--main :: IO ()
main = do args <- getArgs
          putStrLn . makeEPIC $ (read (head args) :: Int)
-- | scanner style input version
-- main = do arg <- getLine
--           putStrLn . makeEPIC $ (read arg :: Int)

-- | make a single block
makeBlock :: Int -> String -> String
makeBlock n = concat . take n . repeat

-- | decide the type of block that gets made
--   True  -> a letter block
--   False -> a spaces block (empty block)
decideBlock :: Int -> Bool -> String -> String
decideBlock n True  l = makeBlock n l
decideBlock n False _ = makeBlock n " "

-- | make a row of blocks
makeRow :: Int -> [Bool] -> String -> String
makeRow n bs = concat . zipWith id (map (decideBlock n) bs) . repeat

-- | a XXXXX block
type1 :: [Bool]
type1 = [True, True, True, True, True]

-- | a X____ block
type2 :: [Bool]
type2 = [True, False, False, False, False]

-- | a X___X block
type3 :: [Bool]
type3 = [True, False, False, False, True]

-- | a __X__ block
type4 :: [Bool]
type4 = [False, False, True, False, False]

-- | abstraction for making a letter
makeLetter :: Int -> [[Bool]] -> String -> String
makeLetter n bs = joinList "\n" . map expandRow . rows
  where rows :: String -> [String]
        rows = zipWith id (map (makeRow n) bs) . repeat
        
        expandRow :: String -> String 
        expandRow = joinList "\n" . take n . repeat

-- | make an E
makeE :: Int -> String
makeE n = makeLetter n bls "E"
  where bls = [type1, type2, type1, type2, type1]

-- | make a P
makeP :: Int -> String
makeP n = makeLetter n bls "P"
  where bls = [type1, type3, type1, type2, type2]

-- | make an I
makeI :: Int -> String
makeI n = makeLetter n bls "I"
  where bls = [type1, type4, type4, type4, type1]

-- | make a C
makeC :: Int -> String
makeC n = makeLetter n bls "C"
  where bls = [type1, type2, type2, type2, type1]

-- | make new lines
makeNewLines :: Int -> String
makeNewLines n = makeBlock (n+1) "\n"

-- | make epic
makeEPIC :: Int -> String
makeEPIC 0 = joinList "\n" ["E", "P", "I", "C"]
makeEPIC n = joinList (makeNewLines n) . epic $ n
  where epic = zipWith id [makeE, makeP, makeI, makeC] . repeat
