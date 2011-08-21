//
//  CategoriesViewController.h
//  Nellodee
//
//  Created by Ada Hopper on 11/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>


@interface CategoriesViewController : UITableViewController <UINavigationControllerDelegate, UITextFieldDelegate>{
	@private
		NSMutableArray *categories;
		NSMutableArray *catString;

}
@property (nonatomic,retain) NSMutableArray *categories;
@property (nonatomic,retain) NSMutableArray *catString;
@end
