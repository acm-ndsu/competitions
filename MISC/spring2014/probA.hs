import Data.List (intersperse)
import System.Environment (getArgs)

-- | compile : ghc --make probA.hs
--          or ghc --make probA
-- | run     : ./probA int

-- | read an int from first argument
main :: IO ()
main = do args <- getArgs
          putStrLn . makeEPIC $ (read (head args) :: Int)
-- | scanner style input version
-- main = do arg <- getLine
--           putStrLn . makeEPIC $ (read arg :: Int)

-- | make a single block
makeBlock :: Int -> String -> String
makeBlock n = concat . take n . repeat

-- | make a XXXXX block
makeType1 :: Int -> String -> String
makeType1 n = makeBlock 5 . makeBlock n

-- | make a X____ block
makeType2 :: Int -> String -> String
makeType2 n l = text ++ spaces
  where text   = makeBlock n l
        spaces = makeBlock (4 * n) " "

-- | make a X___X block
makeType3 :: Int -> String -> String
makeType3 n l = concat [text, spaces, text]
  where text   = makeBlock n l
        spaces = makeBlock (3 * n) " "

-- | make a __X__ block
makeType4 :: Int -> String -> String
makeType4 n l = concat [spaces, text, spaces]
  where spaces = makeBlock (2 * n) " "
        text   = makeBlock n l

-- | make l
makeLetter :: Int -> String -> [(String -> String)] -> String
makeLetter n l gfs = join "\n" expandRows 
  where rows       = zipWith id gfs . repeat $ l
        expandRows = map (join "\n"  . take n . repeat) rows

-- | make an E
makeE :: Int -> String
makeE n = makeLetter n "E" gfs
  where gfs = [ makeType1 n  -- XXXXX
              , makeType2 n  -- X____
              , makeType1 n  -- XXXXX
              , makeType2 n  -- X____
              , makeType1 n  -- XXXXX
              ]

-- | make an P
makeP :: Int -> String
makeP n = makeLetter n "P" gfs
  where gfs = [ makeType1 n  -- XXXXX
              , makeType3 n  -- X___X
              , makeType1 n  -- XXXXX
              , makeType2 n  -- X____
              , makeType2 n  -- X____
              ]

-- | make a I
makeI :: Int -> String
makeI n = makeLetter n "I" gfs
  where gfs = [ makeType1 n  -- XXXXX
              , makeType4 n  -- __X__
              , makeType4 n  -- __X__
              , makeType4 n  -- __X__
              , makeType1 n  -- XXXXX
              ]

-- | make a C
makeC :: Int -> String
makeC n = makeLetter n "C" gfs
  where gfs = [ makeType1 n  -- XXXXX
              , makeType2 n  -- X____
              , makeType2 n  -- X____
              , makeType2 n  -- X____
              , makeType1 n  -- XXXXX
              ]

-- | make new lines
makeNewLines :: Int -> String
makeNewLines n = makeBlock (n+1) "\n"

-- | make epic
makeEPIC :: Int -> String
makeEPIC 0 = join "\n" ["E", "P", "I", "C"]
makeEPIC n = join (makeNewLines n) . epic $ n
  where epic = zipWith id [makeE, makeP, makeI, makeC] . repeat

-- | repeat the row n times
expandRows :: Int ->  String -> String
expandRows n = join "\n" . take n . repeat

-- | join strings with delimiter
join :: [a] -> [[a]] -> [a]
join d = concat . intersperse d
