import System.Environment (getArgs)
import Util (joinList, split)

-- | author  : Joseph Ching
-- | run     : runhaskell probB.hs prob.in
-- assume missingH is not installed so write joinList and split manually.  From
-- there, it is just io and zipping left.

main :: IO ()
main = do args  <- getArgs
          input <- readFile (head args)
          putStrLn (convert input)

-- | read, convert, sort, show
convert :: String -> String
convert = joinList "\n" . map (show . g) . intList
  where intList = map (\x -> read x :: Int) . init . split "\n"

-- | implements the G(n) function recursively
g :: Int -> Int
g n | n <= 0    =  n
    | otherwise = g(n-2) + g(n-4) + g(n-6)

-- | transform G(n) from recursive to an iterative process

-- | a step of the g function
gStep :: [Int] -> [Int]
gStep l@(n1:n2:n3:n4:n5:n6:xs) = shift l (n2 + n4 + n6)
gStep _                        = [0, (-1), (-2), (-3), (-4), (-5)]

-- | shifts a list to the right and append an element to the end
shift :: [a] -> a -> [a]
shift [] x = [x]
shift xs x = (init xs) ++ [x]
